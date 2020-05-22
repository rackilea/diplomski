public class Test {
    private static String name = "Andrew";
    public static String fullName = name + " Barnes";

    public static void setName(String nameArg) {
        name = nameArg;
        fullName = nameArg + " Barnes";
    }

}