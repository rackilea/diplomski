public class Test1 {

    public static String var1;

    static int main(String[] args) {
        var1 = "This is a test!"; // Set var1 first
        Test2.Test2(args); // The call function that does something with var1
    }
}