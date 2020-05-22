<!-- main in MyApplication -->
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame frame = new JFrame();
                frame.setTitle("MyApplication via JWS");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // add here the real UI to the frame: setUpGUI(frame);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

<!-- Init() in MyApplication extends JApplet -->

    @Override
    public void init() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                // add here the real UI to the applet: setUpGUI(MyApplication.this);
            }
        });
    }