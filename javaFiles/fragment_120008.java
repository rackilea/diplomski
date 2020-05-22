public final class MyClass {
    private static WeakReference<MyClass> instance;
    public static synchronized MyClass getInstance() {
        MyClass classInstance = null;
        if (instance != null) {
            classInstance = instance.get();
            if(classInstance != null)
            {
                return classInstance;
            }
        }

        classInstance = new MyClass();
        instance = new WeakReference<MyClass>(classInstance);

        //This is now a strong reference and can't be GC'ed between the previous line and this one.
        return classInstance;
    }
}