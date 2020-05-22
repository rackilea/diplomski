public class Application {
    static final class Constants {
        public static String name = "globe";
    }
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Constants.name);
            }
        });
        thread.start();
    }
}