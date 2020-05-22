public abstract class BaseClass {
    private static HashSet<Class<?>> instances = new HashSet<>();

    protected BaseClass() {
        checkInstances();
    }

    private synchronized void checkInstances() {
        boolean duplicate = instances.add(getClass());

        if (duplicate) {
           throw new RuntimeException("Duplicate class " + getClass().getName()); 
        }
    }
}