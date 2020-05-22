public class InnerClassTest {
    public static void main(String[] args) throws Exception {
        Constructor<OneClass> constructor = OneClass.class.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        OneClass instance = constructor.newInstance("John");
        InnerClass innerClass = new InnerClass(1, instance);
    }
}