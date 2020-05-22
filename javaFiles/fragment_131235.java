String[] colNames = {"Item", "Count"};
DefaultTableModel dtm = new DefaultTableModel(colNames, 0);

JPanel j = new JPanel(new BorderLayout());

JTable t = new JTable(dtm);
t.setBackground(Color.GREEN);

t.getTableHeader().setReorderingAllowed(false);
t.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

t.getColumnModel().getColumn(0).setPreferredWidth(113); 

j.add(new JScrollPane(t), BorderLayout.CENTER);