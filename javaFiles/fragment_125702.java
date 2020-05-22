public class RegexTest {
        public static void Main(String[] args) {
            String pattern = "^\\d+(:[A-Za-z0-9]+){2}$";
            String example = "333:a3b4c:12adf3456";
            if (example.matches(pattern)) {
               System.out.println("Matches");
            }   
        }
    }