private CustomCanvas myCan;

public void init() {
try {
    java.awt.EventQueue.invokeAndWait(new Runnable() {
        public void run() {
            initComponents();

            myCan = new CustomCanvas();
            myCan.setBounds(100, 100, 200, 200);
            getContentPane().add(myCan);
            // ...