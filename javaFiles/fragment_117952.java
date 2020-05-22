public static void main(String[] args) {
    JFrame frame = new JFrame("Server");
    frame.setContentPane(new ServerTest().Panel); //  *************** (A)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
    ServerTest application = new ServerTest();  //  *************** (B)
    application.IOSetup();
}