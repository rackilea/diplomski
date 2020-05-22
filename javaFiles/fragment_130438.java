public class Test {
    public static void main(String args[]) {
        SecurityManager sm = System.getSecurityManager();
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkExit(int status) {
                throw new SecurityException("Client program exited.");
            }
        });

        try {
            System.out.println("hello");
            System.exit(0);
            System.out.println("world");
        } catch (SecurityException se) {
            System.out.println(se.getMessage());
        }
    }
}