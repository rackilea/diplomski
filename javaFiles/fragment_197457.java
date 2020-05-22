public class WrapperUtils {
    private WrapperClass wrapperClass;
    public WrapperUtils(WrapperClass wrapperClass) {
        this.wrapperClass = wrapperClass;
    }

    public void processClasses() {
        doSomething(wrapperClass.class1);
        doSomething(wrapperClass.class2);
    }

    public void doSomething(Class clazz) {
        clazz.someInteraction();
    }
}