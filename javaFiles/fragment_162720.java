public class SomeTest {

    public static String string1 = null; // It's a global String

    @Test
    public void test1() {
        string1 = "blabla"; // Change value for global String
        System.out.println(string1); // Print value of global String
    }

    @Test
    public void test2() {
        System.out.println(string1); // Print value of global String
    }

}