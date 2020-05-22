public class PatternExample {
    private static final String[] MESSAGES = {
        "Good javascript:r(0)",
        "Good javascript:l(50003843)",
        "Good javascript:r(1123934)",
        "Bad javascript:|(5)",
        "Bad javascript:r(53d)",
        "Bad javascript:l()",
    };
    public static void main(String[] args) {
        for (String s : MESSAGES) {
            System.out.println(s.replaceAll("javascript:[rl]\\(\\d+\\)", ""));
        }
    }  
}