JFrame frame = new JFrame("Sort Records based on Time");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

Object rows[][] = { { "Loganathan Mohanraj", 31 },
    { "Renuka Loganathan", 26 } };

String columns[] = { "Name", "Age" };

final JPopupMenu popUp = new JPopupMenu("Customized Tool Tip");

final JTable table = new JTable(new DefaultTableModel(rows, columns));
table.addMouseMotionListener(new MouseMotionAdapter() {
    @Override
    public void mouseMoved(MouseEvent e) {
    int row = table.rowAtPoint(e.getPoint());
    int column = table.columnAtPoint(e.getPoint());

    Rectangle bounds = table.getCellRect(row, column, true);

    popUp.setVisible(false);
    popUp.removeAll();
    popUp.add(new JTextField("Mouse Position - Row : " + row + ", Column : " + column));
    popUp.show(table, bounds.x, bounds.y + bounds.height);
    popUp.setVisible(true);
    }
});

JScrollPane pane = new JScrollPane(table);

frame.add(pane, BorderLayout.CENTER);

frame.setSize(300, 150);
frame.setVisible(true);