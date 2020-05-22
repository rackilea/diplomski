public class A
    static final ServerSocket ss = createServerSocket();

    private static ServerSocket createServerSocket() {
        try {
            return new ServerSocket(6666);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}