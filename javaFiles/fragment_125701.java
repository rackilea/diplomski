public class RegexTest {
    public static void Main(String[] args) {
        String pattern = "^\\d+(:([A-Za-z]+|\\d+)){2}$";
        String example = "333:abc:123456";
        if (example.matches(pattern)) {
           System.out.println("Matches");
        }   
    }
}