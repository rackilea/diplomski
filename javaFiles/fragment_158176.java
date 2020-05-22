public class MainFrame extends JFrame {
    public static void main(String[] args) {
        new MainFrame();
    }

    public MainFrame() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        Component panel = new JPanel();
        panel.setBackground(Color.blue);
        add(panel, c);
        c.gridx = 1;
        c.weightx = 0;
        c.anchor = GridBagConstraints.CENTER;
        add(new JButton("Button"), c);
        c.gridx = 2;
        c.weightx = 1;
        c.anchor = GridBagConstraints.WEST;
        JLabel label = new JLabel("Label");
        add(label, c);

        panel.setPreferredSize(label.getPreferredSize());

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}