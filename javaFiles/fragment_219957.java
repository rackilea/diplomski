public class TableTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TableTest::new);
    }

    private final static String[] COLUMNS = { "x", "x^2", "x^3", "x^4" };
    DefaultTableModel model = new DefaultTableModel(COLUMNS, 0);

    TableTest() {
        JFrame frame = new JFrame("Table Test");
        frame.setSize(600, 300);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTable tbl = new JTable(model);
        frame.add(new JScrollPane(tbl), BorderLayout.CENTER);

        JPanel btns = new JPanel();
        frame.add(btns, BorderLayout.PAGE_START);
        btns.add(new JButton(fillTable));

        frame.setVisible(true);
    }

    @SuppressWarnings("serial")
    Action fillTable = new AbstractAction("Fill Table") {
        @Override
        public void actionPerformed(ActionEvent e) {
            fillTable.setEnabled(false);
            Query query = new Query();
            query.execute();
        }
    };

    class Query extends SwingWorker<Void, String[]> {

        @Override
        protected void process(List<String[]> chunks) {
            for (String[] row : chunks) {
                model.addRow(row);
            }
        }

        @Override
        protected Void doInBackground() throws Exception {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(400); // Slow database retrieval :-)
                String[] row = new String[4];
                row[0] = Integer.toString(i);
                row[1] = Integer.toString(i * i);
                row[2] = Integer.toString(i * i * i);
                row[3] = Integer.toString(i * i * i * i);
                publish(row);
            }
            return null;
        }

        @Override
        protected void done() {
            fillTable.setEnabled(true);
        }
    }
}