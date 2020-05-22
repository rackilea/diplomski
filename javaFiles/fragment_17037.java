public class Main {

    public static MyFrame frame;

    public static void main(String[] args) throws InterruptedException,
            ExecutionException, UnknownHostException, IOException {

        frame = new MyFrame();
        new Thread() {
            public void run() {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        frame.addTab("Test");
                    }
                });
                try {
                    this.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        frame.addTab("Test2");
                    }
                });
            }
        }.start();
    }
}