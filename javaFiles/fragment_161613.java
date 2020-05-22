public class AuthProvider {
    public static final String AUTH_KEY;

    static {
        AUTH_KEY = String.valueOf(new Random().nextInt(5000) + 1);
    }
}