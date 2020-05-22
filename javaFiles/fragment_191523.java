public class Test2 {
    public static final Object LOCK = new Object();
    static int count = 0;

    public static void main(String[] args) {
        try {
            System.out.println(new Date());
            final ApplicationServiceClient app = WSClient.getClient("http://192.168.1.15:81/az-server", ApplicationServiceClient.class);
            final int max=250;
            for (int i = 1; i <= max; i++) {
                Thread t = new Thread() {
                    public void run() {
                        synchronized (LOCK) {
                            app.verifyToken("7056451004350030976");
                        }
                        System.out.print(count++);
                        System.out.print(", ");
                        if (count >= max)
                            System.out.println("\n" + new Date());
                    }
                };

                t.start();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}