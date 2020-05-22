public static void main ( String[] args )
{
    final JFrame frame = new JFrame ();

    final JList list = new JList (
            new Object[]{ Cursor.DEFAULT_CURSOR, Cursor.CROSSHAIR_CURSOR, Cursor.TEXT_CURSOR,
                    Cursor.WAIT_CURSOR, Cursor.SW_RESIZE_CURSOR, Cursor.SE_RESIZE_CURSOR,
                    Cursor.NW_RESIZE_CURSOR, Cursor.NE_RESIZE_CURSOR, Cursor.N_RESIZE_CURSOR,
                    Cursor.S_RESIZE_CURSOR, Cursor.W_RESIZE_CURSOR, Cursor.E_RESIZE_CURSOR,
                    Cursor.HAND_CURSOR, Cursor.MOVE_CURSOR } );

    list.setCellRenderer ( new DefaultListCellRenderer ()
    {
        public Component getListCellRendererComponent ( JList list, Object value, int index,
                                                        boolean isSelected,
                                                        boolean cellHasFocus )
        {
            JLabel label = ( JLabel ) super
                    .getListCellRendererComponent ( list, value, index, isSelected,
                            cellHasFocus );
            label.setText ( "Cursor constant: " + value );
            return label;
        }
    } );

    list.addMouseMotionListener ( new MouseMotionListener ()
    {
        public void mouseDragged ( MouseEvent e )
        {
            updateCursor ( e );
        }

        public void mouseMoved ( MouseEvent e )
        {
            updateCursor ( e );
        }

        private void updateCursor ( MouseEvent e )
        {
            int cursor = ( Integer ) list.getModel ()
                    .getElementAt ( list.locationToIndex ( e.getPoint () ) );
            list.setCursor ( Cursor.getPredefinedCursor ( cursor ) );
        }
    } );

    frame.add ( list );

    frame.pack ();
    frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
    frame.setLocationRelativeTo ( null );
    frame.setVisible ( true );
}