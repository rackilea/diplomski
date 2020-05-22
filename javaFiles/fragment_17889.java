public class GlobalUserDetails {
    private static volatile String name = "not set";
    public static void setName(String name) {
        GlobalUserDetails.name = name;
    }
    public static String getName() {
        return name;
    }
}