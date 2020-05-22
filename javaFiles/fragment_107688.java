public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500,500));

        final JTable table = new JTable(new MyModel());
        for(int i =0; i < 7; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new tblCalendarRenderer());
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int column = table.columnAtPoint(e.getPoint());

                Object obj = table.getValueAt(row, column);
                System.out.println("value " + obj);
                CellValue cellValue = (CellValue)obj;
                cellValue.highlightEnd++;
                table.repaint();
            }
        });
        table.setRowHeight(50);
        JScrollPane scp = new JScrollPane(table);
        frame.add(scp);
        frame.setVisible(true);
    }
}