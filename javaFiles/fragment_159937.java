public class MyPanel extends JPanel {

    public JTextField tf;
    public JButton swap;
    public JLabel panel_label;

    public MyPanel(int n) {
        tf = new JTextField(25);
        swap = new JButton("Swap");
        panel_label = new JLabel("panel " + n);

        add(tf);
        add(swap);
        add(panel_label);
    }

    public JButton getSwap() {
        return swap;
    }

    public JTextField getTextField() {
        return tf;
    }

}