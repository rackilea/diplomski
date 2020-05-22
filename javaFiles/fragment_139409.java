class MySynchronizedTest extends SynchronizedTestTrait
{
    val classUnderTest = new MySynchronized


    @Test
    def synch_is_synchronized
    {
        this.assertSynchronized
        {
            this.classUnderTest.synch
        }
    }

    @Test
    def unsynch_not_synchronized
    {
        this.assertNotSynchronized
        {
            this.classUnderTest.unsynch
        }
    }
}