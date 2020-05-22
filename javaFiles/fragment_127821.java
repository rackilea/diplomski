public class test {
    static int num = 111;
    public static void main(String[] args) throws Exception {
        new Thread() {
            @Override
            public void run() {
                num = 222;
            }
        }.start();
    }
}