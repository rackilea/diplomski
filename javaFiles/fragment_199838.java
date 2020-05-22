public class App extends JFrame {
    private DefaultTableModel model = new DefaultTableModel(new Object[][] {
            { "Value1", "Value2", "Value3" }, { "Object1", "Object2", "Object3" } }, new String[] {
            "Column1", "Column2", "Column3" });
    private JTable table = new JTable(model);
    private JPanel bottomPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                App a = new App();
                a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                a.setLocationRelativeTo(null);
                a.setVisible(true);
            }
        });
    }

    public App() {
        JSplitPane pane = new JSplitPane();
        pane.setOrientation(SwingConstants.HORIZONTAL);
        pane.setLeftComponent(new JScrollPane(table));
        bottomPanel = new JPanel();
        bottomPanel.add(new JLabel("properties for column will be here"));
        pane.setRightComponent(bottomPanel);
        add(pane);

        ListSelectionListener listener = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int column = table.getSelectedColumn();
                int row = table.getSelectedRow();
                if(row != -1 && column != -1) {
                    bottomPanel.removeAll();
                    //Here you add your components/create appropriate panel
                    //e.g. bottomPanel.add(new PropertiesPanelForValue1(...));
                    bottomPanel.add(new JLabel("User selected column " + column + " and row " + row
                            + " with value: '" + table.getValueAt(row, column) + "'"));
                    bottomPanel.revalidate();
                }
            }
        };
        table.getSelectionModel().addListSelectionListener(listener);
        table.getColumnModel().getSelectionModel().addListSelectionListener(listener);

        pack();

        pane.setDividerLocation(0.3);
        setSize();
    }

    private void setSize() {
        double widthPart = 0.3;
        double heightPart = 0.5;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.getWidth() * widthPart);
        int height = (int) (screenSize.getHeight() * heightPart);
        setSize(width, height);
        Dimension windowSize = getSize();
        int x = (int) ((screenSize.getWidth() - windowSize.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - windowSize.getHeight()) / 2);
        setLocation(x, y);
    }
}