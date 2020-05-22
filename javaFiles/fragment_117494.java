public class Main {
    public static void main(String [] args) {

        String[] tests = {
                "test substr 'test substr' substr",
                "test sstr 'test sstr' sstr",
                "test 'test substr'"
        };

        String regex = "substr(?=([^']*'[^']*')*[^']*$)";

        for(String t : tests) {
            System.out.println(t.replaceAll(regex, "YYYY"));
        }
    }
}