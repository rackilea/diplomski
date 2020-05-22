public class SecureViews {
    public static class Public{};
    public static class Authenticated extends Public{};
    public static class User extends Authenticated{};
    public static class Internal extends User {};
}