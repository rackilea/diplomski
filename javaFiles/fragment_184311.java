MouseAdapter ma = new MouseAdapter()
{
    TableColumn column;
    int columnWidth;
    int pressedX;

    public void mousePressed(MouseEvent e)
    {
        JTableHeader header = (JTableHeader)e.getComponent();
        TableColumnModel tcm = header.getColumnModel();
        int columnIndex = tcm.getColumnIndexAtX( e.getX() );
        Cursor cursor = header.getCursor();

        if (columnIndex == tcm.getColumnCount() - 1
        &&  cursor == Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR))
        {
            column = tcm.getColumn( columnIndex );
            columnWidth = column.getWidth();
            pressedX = e.getX();
            header.addMouseMotionListener( this );
        }
    }

    public void mouseReleased(MouseEvent e)
    {
        JTableHeader header = (JTableHeader)e.getComponent();
        header.removeMouseMotionListener( this );
    }

    public void mouseDragged(MouseEvent e)
    {
        int width = columnWidth - pressedX + e.getX();
        column.setPreferredWidth( width );
        JTableHeader header = (JTableHeader)e.getComponent();
        JTable table = header.getTable();
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = (JScrollPane)table.getParent().getParent();
        scrollPane.revalidate();
    }
};

JTable fixed = fixedColumnTable.getFixedTable();
fixed.getTableHeader().addMouseListener( ma );