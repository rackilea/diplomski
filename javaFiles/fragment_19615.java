MyServiceClass {

    Thread thread;

    public static boolean isConfigurationValid(){
        loadConfigFile(); // private method of same class
        validateDBConfiguration();// private method of same class
        initializeThread();// private method of same class
    }

    private static void initializeThread (boolean usePrimaryPort) {
        {
            if (thread == null){
                synchronized (MyServiceClass.class){
                    if (thread == null){
                        Thread thread = new Thread();
                        Thread.start();
                    }
                }
            }
            return;
        }
    }
    public static Thread getThread(){
        return thread;
    }
}