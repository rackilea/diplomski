public class QuickTest {
    public static void main(String args[]) {
        String theString = "toto \\d{123} 456 789";
        theString = theString.replace("{", "NCHAR(0x7B)");
        theString = theString.replace("}", "NCHAR(0x7D)");
        System.out.println(theString);
    }
}