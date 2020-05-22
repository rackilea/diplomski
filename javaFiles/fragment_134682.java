public class SplitPaneTest extends JFrame {
    public SplitPaneTest() {
        super("test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel left = new JPanel();
        JPanel right = new JPanel();

        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, right);
        System.out.println(sp.getDividerSize()); //Prints 10
        sp.setDividerSize(1);

        add(sp, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SplitPaneTest().setVisible(true);
        });
    }
}