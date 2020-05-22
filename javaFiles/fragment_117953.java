public static void main(String[] args) {

    ServerTest application = new ServerTest();  // create one instance

    JFrame frame = new JFrame("Server");
    // frame.setContentPane(new ServerTest().Panel);

    frame.setContentPane(application.Panel);     // and use in both places

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);

    //ServerTest application = new ServerTest();
    application.IOSetup();                 // and use in both places
}