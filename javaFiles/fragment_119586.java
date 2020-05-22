class MenuExample implements ActionListener {
    JTextArea t1, t2;
    JTextField t3;
    JButton b1, b2;  // these are no longer null

    MenuExample() {
        JFrame f = new JFrame("Menu and MenuItem EX");

        // final JButton b1 = new JButton("+"); 
        // final JButton b2 = new JButton("-");
        b1 = new JButton("+");
        b2 = new JButton("-");