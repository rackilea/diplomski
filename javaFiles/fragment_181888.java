public class A {
    static final ServerSocket ss;

    static {
        try {
            ss = new ServerSocket(6666);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}