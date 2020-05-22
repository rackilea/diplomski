public class TryCatchTest {
    public static void main(String[] args) {
        try {
            System.out.println("foo");
            throw new NullPointerException();
        } finally {
            try {
                System.out.println("bar");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } // exception thrown here
    }
}