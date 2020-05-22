public class TabbedPanelExample extends JFrame {
    public TabbedPanelExample() {
        super("test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTabbedPane pane = new JTabbedPane();
        pane.addTab("FirstTab", createFirstTab());
        pane.addTab("SecondTab", createSecondTab());

        add(pane);
        setSize(400, 400);
        setLocationRelativeTo(null);
    }

    private Component createFirstTab() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Some Component"));
        panel.add(new JTextField("Some Other Component"));
        return panel;
    }

    private Component createSecondTab() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Some Component"));
        panel.add(new JButton("Some Other Component"));
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TabbedPanelExample().setVisible(true);
        });
    }

}