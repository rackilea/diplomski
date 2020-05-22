Below is the Code from AQS(AbstractQueueSynchronizer) from java

     public final void acquireInterruptibly(int arg) throws InterruptedException {
            if (Thread.interrupted())
                throw new InterruptedException();
            if (!tryAcquire(arg))
                doAcquireInterruptibly(arg);
        }