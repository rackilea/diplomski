public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        String[] tempColumnNames = new String[] { "#", "Name", "Family", "Age" };
        Vector<String> columnNames = new Vector<String>(
                Arrays.asList(tempColumnNames));
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        for (int i = 0; i < 10; i++) {
            Vector<String> rowData = new Vector<String>(Arrays.asList((i + 1)
                    + "", "Name-" + (i + 1), "Family-" + (i + 1), i + 20 + ""));
            data.add(rowData);
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        final JTable table = new JTable(model);
        //
        JComboBox<String> ageCombo = new JComboBox<String>(
                new DefaultComboBoxModel<String>(new String[] { "20", "21",
                        "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        table.getColumnModel().getColumn(3)
                .setCellEditor(new DefaultCellEditor(ageCombo));
        //
        frame.getContentPane().add(new JScrollPane(table));
        //
        JButton showDialogButton = new JButton("Show Selected Age");
        showDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "selected age: "
                        + table.getValueAt(table.getSelectedRow(), 3));
            }
        });
        frame.getContentPane().add(showDialogButton, BorderLayout.NORTH);
        //
        frame.setBounds(500, 500, 350, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}