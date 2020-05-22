public static void main(String[] args) {
    JFrame frame = new JFrame("test");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(new Dimension(500, 500));
    frame.getContentPane().setLayout(new GridLayout(5, 5));
    JComboBox<String> comboBox1 = new JComboBox<>(new String[] { "11", "12" });
    JComboBox<String> comboBox2 = new JComboBox<>(new String[] { "21", "22" });
    ItemListener listener = (e) -> {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            if (e.getSource() == comboBox1) {
                System.out.printf("JComboBox 1 state changed: %s selected\n", e.getItem());
            }
            else if (e.getSource() == comboBox2) {
                System.out.printf("JComboBox 2 state changed: %s selected\n", e.getItem());
            }
        }
    };
    comboBox1.addItemListener(listener);
    comboBox2.addItemListener(listener);
    frame.getContentPane().add(comboBox1);
    frame.getContentPane().add(comboBox2);
    frame.setVisible(true);
}