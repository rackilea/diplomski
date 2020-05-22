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
                column.setHeaderValue("I don't see the problem");
                model.addColumn(column);

                final JTableHeader header = new JTableHeader();
                header.setColumnModel(model);

                DefaultTableModel tm = new DefaultTableModel(new Object[]{"A", "B", "C"}, 0);
                tm.addRow(new Object[]{"1", "2", "3", "4"});
                tm.addRow(new Object[]{"5", "6", "7", "8"});
                tm.addRow(new Object[]{"9", "10", "11", "12"});
                tm.addRow(new Object[]{"13", "14", "15", "16"});
                final JTable table = new JTable(tm);

                final JScrollPane scrollPane = new JScrollPane(table);
                /**
                 * For some reason, the header isn't being applied as soon as the
                 * table is added to the scroll pane, so we need to jump our next
                 * request to the end of the of event queue so that it will
                 * occur some time in the future
                 */
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        scrollPane.setColumnHeaderView(header);
                    }

                });

                table.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        column.setWidth(table.getWidth());
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