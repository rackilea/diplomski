public class Main {
    public static void main(String[] args) {
        String s = "This is a test() function";
        String s2 = "This is a test    () function";
        System.out.println(s.matches("(?:.*)((?<=\\s))(test(?:\\s+)?\\()(?:.*)")); 
        //true
    }
}