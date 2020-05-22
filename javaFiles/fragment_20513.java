public class ThreadTest {
    public static void main(String[] args) {
        final Thread main = Thread.currentThread();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Thread edt = Thread.currentThread();

                System.out.println(main);
                System.out.println(edt);
                System.out.println(main.equals(edt));
            }
        });
    }
}