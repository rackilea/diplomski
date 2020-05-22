public class DaemonThreadPlay {
    public static void main(String [] args) {
        Thread daemonThread = new Thread() {
            public void run() {
                while (true) {
                    try {
                        System.out.println("Try block executed");
                        Thread.sleep(1000l);
                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                }
            }

            @Override
            public void finalize() {
                System.out.println("Finalize method called");
            }
        };
        daemonThread.setDaemon(true);
        daemonThread.start();

        try {
            Thread.sleep(2500l);
        } catch (Throwable t) {
            //NO-OP
        }
    }
}