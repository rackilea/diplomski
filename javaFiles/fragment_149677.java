public class TaskView extends JFrame {

    public TaskView() throws HeadlessException {
        createGUI();
    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, createPanel(), createPanel());
        splitPane.setResizeWeight(0.5);
        add(splitPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JMenuItem menuItem1 = new JMenuItem("MenuItem 1");
        JMenuItem menuItem2 = new JMenuItem("MenuItem 2");
        JMenuItem menuItem3 = new JMenuItem("MenuItem 3");

        JMenu menu = new JMenu("Main");
        menu.add(menuItem1);
        menu.addSeparator();
        menu.add(menuItem2);
        menu.add(menuItem3);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        menuBar.add(new JMenu("View"));

        panel.add(menuBar, BorderLayout.PAGE_START);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TaskView().setVisible(true));
    }
}