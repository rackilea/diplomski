public class SomeTest {
    public static void main(String[] args) {
        final int length1 = new SomeClass()     .getStringCollection().iterator().next().length();
        final int length2 = new SomeTypedClass<String>().getStringCollection().iterator().next().length(); // no more compilation error
    }
}