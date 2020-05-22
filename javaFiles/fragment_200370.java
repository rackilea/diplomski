public class MySingletonClass {
    // The constructor must be private to prevent external instantiation
    private MySingletonClass(){};
    /** The public static method allowing to get the instance */
    public static MySingletonClass getInstance() {
        return MySingletonClassHolder.INSTANCE;
    }
    /**
     * The static inner class responsible for creating your instance only on demand,
     * because the static fields of a class are only initialized when the class
     * is explicitly called and a class initialization is synchronized such that only 
     * one thread can perform it, this rule is also applicable to inner static class
     * So here INSTANCE will be created only when MySingletonClassHolder.INSTANCE 
     * will be called
     */
    private static class MySingletonClassHolder {
        private static final MySingletonClass INSTANCE = new MySingletonClass();
    }
}