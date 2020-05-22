public class ClassUtil extends SecurityManager {

    public static Class getCurrentClass() {
        return getClassContext()[1];
    }
}

public class TestA {
    private static thisClass = ClassUtil.getCurrentClass();

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(thisClass);
    }
}

public class TestB {
    private static thisClass = ClassUtil.getCurrentClass();

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(thisClass);
    }
}