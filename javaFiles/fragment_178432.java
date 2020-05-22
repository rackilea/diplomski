public class Test {
    interface SomeInterface { }
    abstract interface SomeAbstractInterface { }
    static abstract class SomeAbstractClass { }
    enum SomeEnum { }

    public static void main(String arg[]) {
        System.out.println(Modifier.toString(SomeInterface.class.getModifiers()));
        System.out.println(Modifier.toString(SomeAbstractInterface.class.getModifiers()));
        System.out.println(Modifier.toString(SomeAbstractClass.class.getModifiers()));
        System.out.println(Modifier.toString(SomeEnum.class.getModifiers()));
    }
}