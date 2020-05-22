public class TestClassUsingEasymock extends EasyMockSupport {

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


    @Test
    public void testAddUsesWriteLock() {
        // Prepare
        final Lock lock = createNiceMock(Lock.class);       
        final IndexData indexData = createNiceMock(IndexData.class);
        EasyMock.expect(indexData.getWriteLock()).andStubReturn(lock);

        // ... now use your new subclass for testing
        final TestClass objectUnderTest = new ClassForTesting(indexData, lock);
        final InputClass input = createNiceMock(InputClass.class);

        lock.lock();
        EasyMock.expectLastCall();

        lock.unlock();
        EasyMock.expectLastCall();

        replayAll();

        // Invoke method under test
        objectUnderTest.add(input);

        // Verify
        verifyAll();
    }
}