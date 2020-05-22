class MenuExample implements ActionListener {
    JTextArea t1, t2;
    JTextField t3;
    JButton b1, b2;  // these stay null!!!

    MenuExample() {
        JFrame f = new JFrame("Menu and MenuItem EX");

        // Don't re-declare the variables here!
        final JButton b1 = new JButton("+");  
        final JButton b2 = new JButton("-");