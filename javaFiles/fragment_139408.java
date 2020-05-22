trait SynchronizedTestTrait
{
    val classUnderTest: AnyRef

    class Gate
    {
        val latch = new java.util.concurrent.CountDownLatch(1)

        def open()
        {
            this.latch.countDown
        }

        def await()
        {
            this.latch.await
        }
    }

    def nanoTime(code: => Unit) =
    {
        val before = System.nanoTime
        code
        val after = System.nanoTime
        after - before
    }

    def assertSynchronized(code: => Unit)
    {
        this.assertThreadSafety(threadSafe = true, millisTimeout = 10L)(code)
    }

    def assertNotSynchronized(code: => Unit)
    {
        this.assertThreadSafety(threadSafe = false, millisTimeout = 60L * 1000L)(code)
    }

    def assertThreadSafety(threadSafe: Boolean, millisTimeout: Long)(code: => Unit)
    {
        def spawn(code: => Unit) =
        {
            val result = new Thread
            {
                override def run = code
            }
            result.start()
            result
        }

        val gate = new Gate

        val lockHolderThread = spawn
        {
            this.classUnderTest.synchronized
            {
                // Don't let the other thread start until we've got the lock
                gate.open()

                // Hold the lock until interruption
                try
                {
                    Thread.sleep(java.lang.Long.MAX_VALUE)
                }
                catch
                {
                    case ignore: InterruptedException => return;
                }
            }
        }

        val measuredNanoTime = nanoTime
        {
            // Don't start until the other thread is synchronized on classUnderTest
            gate.await()
            spawn(code).join(millisTimeout, 0)
        }

        val nanoTimeout = millisTimeout * 1000L * 1000L

        Assert.assertEquals(
            "Measured " + measuredNanoTime + " ns but timeout was " + nanoTimeout + " ns.",
            threadSafe,
            measuredNanoTime > nanoTimeout)

        lockHolderThread.interrupt
        lockHolderThread.join
    }
}