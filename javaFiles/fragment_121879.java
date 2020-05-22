public class Main {
    public static void main(String[] args) throws Exception {
        String[] tests = {
                "11111111111",
                "99999999999",
                "99999999998",
                "12345678900"
        };
        for(String t : tests) {
            System.out.println(t+" :: "+t.matches("(\\d)(?!\\1+$)\\d{10}"));
        }
    }
}