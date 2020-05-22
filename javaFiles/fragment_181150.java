public final class ApplicationContext {

    public static abstract class Worker {

        private final ApplicationContext mApplicationContext;

        public Worker(final ApplicationContext pApplicationContext) {
            this.mApplicationContext = pApplicationContext;
        }


        public final ApplicationContext getApplicationContext() {
            return this.mApplicationContext;
        }

    }

    private final int mX;

    ApplicationContext(final String[] pArgs) {
        this.mX = pArgs[0];
    }


    public final int getX() {
        return this.mX();
    }

}