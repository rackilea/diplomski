public class Main {
    public static void main(String s[]) {
        // Tests
        System.out.println(matches("RBGPYO"));
        System.out.println(matches("RBGP"));
        System.out.println(matches("R1BGP"));
        System.out.println(matches("ABCD"));
        System.out.println(matches("1234"));
        System.out.println(matches("BGPY"));
        System.out.println(matches("BYPG"));
    }

    static boolean matches(String input) {
        return input.matches("[RBGPYO]{4}");
    }
}