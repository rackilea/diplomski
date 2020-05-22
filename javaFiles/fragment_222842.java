public class Locker {
    private String secret = "This is my secret";

    public class Util {
    }

    public class StealSecret extends Locker.Util {
        public StealSecret() {
            System.out.println(secret); // access
        }
    }
}