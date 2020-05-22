class MyGUI extends JFrame {

    public MyGUI() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);// <- don't close window 
                                                             // when [X] is pressed

        final MyGUI gui = this;
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int i = JOptionPane.showConfirmDialog(gui,
                        "Are you sure to exit?", "Closing dialog",
                        JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        setSize(200, 200);
        setVisible(true);
    }

    //demo
    public static void main(String[] args) {
        new MyGUI();
    }
}