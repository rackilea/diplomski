public class TestClassUsingMockito {
    /**
    We extend the original class under test so that we can override the creation of IndexData and
    thereby remove the responsibility of creating this object from the @Test method
    */
    private class ClassForTesting extends TestClass {

        private Lock lock;
        private IndexData indexData;

        public ClassForTesting(IndexData indexData, Lock lock) {
            this.indexData = indexData;
            this.lock = lock;
        }

        @Override
        protected IndexData getIndex(InputClass input) {
            return indexData;
        }
    }

    /**
    Look Ma' no more Spys!
    */
    @Test
    public void testAddUsesWriteLock() {        
        // Prepare
        final Lock lock = Mockito.mock(Lock.class);
        final IndexData indexData = Mockito.mock(IndexData.class);
        Mockito.doReturn(lock).when(indexData).getWriteLock();
        // ... now use your new subclass for testing
        final TestClass objectUnderTest = new ClassForTesting(indexData, lock);
        final InputClass input = Mockito.mock(InputClass.class);

        // Invoke method under test
        objectUnderTest.add(input);

        // Verify
        Mockito.verify(indexData).getWriteLock();
        Mockito.verify(indexData, Mockito.never()).getReadLock();
        Mockito.verify(lock).lock();
        Mockito.verify(lock).unlock(); 
    }
}