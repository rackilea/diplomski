JButton button1, button2;

public JButtonDemo() {
    button1 = new JButton();
    button1.setText("Click Me 1");
    button1.addActionListener(this);
    add(button1);

    button2 = new JButton();
    button2.setText("Click Me 2");
    button2.addActionListener(this);
    add(button2);
}

public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == button1) {
        JOptionPane.showMessageDialog(this, "Hi");
    } else if (ae.getSource() == button2) {
        JOptionPane.showMessageDialog(this, "bye");
    }
}

public static void main(String args[]) {
    JFrame f = new JFrame("JButon Demo Example ");
    f.setContentPane(new JButtonDemo());
    f.pack();
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}