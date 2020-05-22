public class TestPane extends JPanel {

    private MyTableModel model;
    private int index = 0;
    public TestPane() {
        String data[][] = {
            {"My teacher took my iPod.", "She said they had a rule;", "I couldn't bring it into class", "or even to the school."},
            {"She said she would return it;", "I'd have it back that day.", "But then she tried my headphones on", "and gave a click on Play."},
            {"She looked a little startled,", "but after just a while", "she made sure we were occupied", "and cracked a wicked smile.", ""},
            {"Her body started swaying.", "Her toes began to tap.", "She started grooving in her seat", "and rocking to the rap."},
            {"My teacher said she changed her mind.", "She thinks it's now okay", "to bring my iPod into class.", "She takes it every day."}
        };

        setLayout(new BorderLayout());

        model = new MyTableModel();

        JTable table = new JTable(model);
        table.setRowHeight(75);
        add(new JScrollPane(table));

        JButton add = new JButton("Add");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < data.length) {
                    model.addRow(data[index]);
                }
                index++;
                if (index >= data.length) {
                    add.setEnabled(false);
                }
            }
        });

        add(add, BorderLayout.SOUTH);
    }

    public class MyTableModel extends AbstractTableModel {

        private List<String[]> rowData;

        public MyTableModel() {
            rowData = new ArrayList<>(25);
        }

        public void addRow(String[] data) {
            rowData.add(data);
            fireTableRowsInserted(rowData.size() - 1, rowData.size() - 1);
        }

        @Override
        public int getColumnCount() {
            return 1;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Object value = null;
            switch (columnIndex) {
                case 0:
                    String[] data = rowData.get(rowIndex);
                    StringJoiner joiner = new StringJoiner("<br>", "<html>", "</html>");
                    for (String text : data) {
                        joiner.add(text);
                    }
                    value = joiner.toString();
                    break;
            }
            return value;
        }

        @Override
        public int getRowCount() {
            return rowData.size();
        }

    }

}