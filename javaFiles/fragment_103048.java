public class BaseClass {

    protected static ChildType myType = ChildType.Invalid;

    ...

    public static boolean methodTwoBase() {
        ...
    }
}

public class ChildA extends BaseClass {

    public static boolean methodOne() {
        ...
    }

    public static boolean methodTwo() {

        myType = ChildType.ChildA;
        return methodTwoBase();
    }
}

public class ChildB extends BaseClass {

    public static boolean methodOne() {
        ...
    }

    public static boolean methodTwo() {

        myType = ChildType.ChildB;
        return methodTwoBase();
    }
}