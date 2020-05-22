public class Program {
    static class Person {
    }

    public static void main(String[] params) throws Exception {
        Object one = new Object();
        Object two = new Person();
        Person three = new Person();
        System.out.println("One compile-type : " + getStaticType(one));
        System.out.println("Two compile-type : " + getStaticType(two));
        System.out.println("Three compile-type : " + getStaticType(three));

    }
    public static Class getStaticType(Person p) {
        return Person.class;
    }
    public static Class getStaticType(Object o) {
        return Object.class;
    }
}