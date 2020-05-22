abstract class SuperClass implements IClass {
    // Don't implement this, but declare it abstract
    // so that we can conform to IClass as well
    public abstract void implementedMethod();

    public void method () {
       // Now this object (which conforms to IClass) has implementedMethod
       // which will be implemented by a concrete subclass.
       implementedMethod();
    }
}