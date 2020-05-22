public class TestTableFilter {

    public static void main(String[] args) {
        new TestTableFilter();
    }

    public TestTableFilter() {
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

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new FilterPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class FilterPane extends JPanel {

        private JTable table;
        private int filter;
        private TableRowSorter<MyModel> sorter;

        public FilterPane() {
            setLayout(new BorderLayout());
            MyModel model = new MyModel();
            sorter = new TableRowSorter<MyModel>(model);
            table = new JTable(model);
            table.setRowSorter(sorter);
            add(new JScrollPane(table));

            JButton filterButton = new JButton("Filter");
            filterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    filter++;
                    System.out.println(filter);
                    RowFilter<MyModel, Integer> rowFilter = null;
                    switch (filter) {
                        case 1:
                            rowFilter = new IDFilter(0);
                            break;
                        case 2:
                            rowFilter = new IDFilter(1);
                            break;
                        default:
                            filter = 0;
                    }
                    sorter.setRowFilter(rowFilter);
                }
            });
            add(filterButton, BorderLayout.SOUTH);
        }

    }

    public class MyModel extends AbstractTableModel {

        private List<RowValue> values;

        public MyModel() {
            values = new ArrayList<>(25);
            for (int index = 0; index < 10; index++) {
                values.add(new RowValue(index % 2, Character.toString((char) (65 + index)), index));
            }
        }

        @Override
        public int getRowCount() {
            return values.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            RowValue row = values.get(rowIndex);
            Object value = null;
            switch (columnIndex) {
                case 0:
                    value = row.getName();
                    break;
                case 1:
                    value = row.getValue();
                    break;
            }
            return value;
        }

        public RowValue getValueAt(int row) {
            return values.get(row);
        }

    }

    public class RowValue {

        private int id;
        private String name;
        private int value;

        public RowValue(int id, String name, int value) {
            this.id = id;
            this.name = name;
            this.value = value;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }

    }

    public class IDFilter extends RowFilter<MyModel, Integer> {

        private int id;

        public IDFilter(int id) {
            this.id = id;
        }

        public boolean include(RowFilter.Entry<? extends MyModel, ? extends Integer> entry) {
            MyModel personModel = entry.getModel();
            RowValue value = personModel.getValueAt(entry.getIdentifier());
            if (value.getId() == id) {
                return true;
            }
            return false;
        }

    }

}