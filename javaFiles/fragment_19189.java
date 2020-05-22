public class TestHeader {

    public static void main(String[] args) {
        new TestHeader();
    }

    public TestHeader() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                TableColumnModel model = new DefaultTableColumnModel();
                final TableColumn column = new TableColumn(0, 250);
                column.setHeaderValue("Test");
                model.addColumn(column);

                JTableHeader header = new JTableHeader();
                header.setColumnModel(model);

                final JTextArea textArea = new JTextArea();

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setColumnHeaderView(header);

                textArea.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        column.setWidth(textArea.getWidth());
                    }
                });

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(scrollPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}