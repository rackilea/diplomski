public class TestStackoverflow {

    @Test
    public void test(){
        TestExceptionHandler exceptionHandler = new TestExceptionHandler();
        EventManager eventManager = EasyMock.createStrictMock(EventManager.class);
        EasyMock.replay(eventManager);

        // Create a MyClass - pass in the eventManager
        MyClass myClass = new MyClass(eventManager);

        // Create thread
        Thread thread = new Thread(myClass);
        thread.setUncaughtExceptionHandler(exceptionHandler);

        // Run your code
        thread.start();

        // WAIT FOR THREAD TO FINISH
        thread.join();

        // Check no exceptions were thrown
        exceptionHandler.verifyNoExceptions();
    }

    private class TestExceptionHandler implements UncaughtExceptionHandler {

        private Throwable e;

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            this.e = e;
        }

        public void verifyNoExceptions() {
            if(e != null) {
                throw new AssertionError("BOOM! Exception caught", e);
            }
        }

    }

    private class MyClass implements Runnable {
        private EventManager eventManager;

        public MyClass(EventManager eventManager) {
            this.eventManager = eventManager;
        }

        public void run(){
            eventManager.sendEvent();
        }
    }

    interface EventManager{
        public void sendEvent();
    }
}