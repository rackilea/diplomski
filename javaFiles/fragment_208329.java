public class MainFrame extends JFrame {

    private JTable table = new JTable(new MyTableModel());

    public MainFrame() throws HeadlessException {
        super("MainFrame");
        createGUI();
    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));

        JButton addI = new JButton("+");
        addI.addActionListener(e -> ((MyTableModel)table.getModel()).setIncomeData(new Data()));

        JButton addE = new JButton("+");
        addE.addActionListener(e -> ((MyTableModel)table.getModel()).setExpenseData(new Data()));

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        panel.add(addI);
        panel.add(addE);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);

        ((MyTableModel)table.getModel()).update();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}