public class TableTest {

    private static class MyObject {
        // empty
    }

    private static class MyObjectTableModel extends AbstractTableModel {
        // no change
    }

    private static void createGUI() {
        JFrame f = new JFrame("TableTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final MyObjectTableModel model = new MyObjectTableModel();
        for (int i = 0; i < 16; i++) {
            model.addRow(new MyObject());
        }
        JTable table = new JTable(model);
        f.add(new JScrollPane(table));
        f.add(new JButton(new AbstractAction("Remove") {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeRow(0);
            }
        }), BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TableTest().createGUI();
            }
        });
    }
}