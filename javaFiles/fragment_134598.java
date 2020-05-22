public class Test {
    public static void main(String args[]) {
        String string = args[0];
        System.out.println("last character: " +
                           string.substring(string.length() - 1)); 
    }
}