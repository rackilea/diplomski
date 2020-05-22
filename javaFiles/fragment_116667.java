public class MyClass {
    /**
     * Thread-safe collection used to store all existing instances
     */
    private static final Collection<MyClass> INSTANCES = new ConcurrentLinkedQueue<>();

    private MyClass() {}

    public static MyClass newInstance() {
        // Create the instance
        MyClass instance = new MyClass();
        // Publish the instance
        INSTANCES.add(instance);
        return instance;
    }

    public static void release(MyClass instance) {
        //Un-publish my instance
        INSTANCES.remove(instance);
    }

    public static void releaseAll(Predicate<MyClass> predicate) {
        //Un-publish all instances that match with the predicate
        INSTANCES.stream().filter(predicate).forEach(INSTANCES::remove);
    }

    public static void apply(Consumer<MyClass> consumer) {
        // Execute some code for each instance
        INSTANCES.stream().forEach(consumer);
    }
}