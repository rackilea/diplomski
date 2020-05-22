public class AnnotationTest {

    public static class A
    {
        @XmlElement(name="item")
        public void doIt() { }
    }

    public static class B extends A
    {
        @XmlElement(name="name")
        public void doIt() { }
    }

    public static void main(String[] args)
    {
        B b = new B();
        Method m = b.getClass().getMethods()[0];
        Annotation[] ann =  m.getDeclaredAnnotations();
        System.out.println( ann.length  );  // prints 1
    }
}