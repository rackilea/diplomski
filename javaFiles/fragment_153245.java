public class PreferredLayoutTest extends JPanel {

    public PreferredLayoutTest() {
        this.setLayout(new PreferredSizeGridLayout(0, 1));
        this.add(createLabel("One"));
        this.add(createLabel("Two"));
    }

    private JLabel createLabel(String s) {
        JLabel label = new JLabel(s);
        label.setOpaque(true);
        label.setBackground(Color.lightGray);
        label.setFont(label.getFont().deriveFont(36f));
        return label;
    }

    private void display() {
        JFrame f = new JFrame("PreferredLayoutTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new PreferredLayoutTest().display();
            }
        });
    }
}