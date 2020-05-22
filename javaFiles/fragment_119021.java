public static void main ( String[] args )
{
    JFrame frame = new JFrame ();

    JTree tree = new JTree ();
    tree.setCellRenderer ( new DefaultTreeCellRenderer ()
    {
        private Border border = BorderFactory.createEmptyBorder ( 4, 4, 4, 4 );

        public Component getTreeCellRendererComponent ( JTree tree, Object value, boolean sel,
                                                        boolean expanded, boolean leaf, int row,
                                                        boolean hasFocus )
        {
            JLabel label = ( JLabel ) super
                    .getTreeCellRendererComponent ( tree, value, sel, expanded, leaf, row,
                            hasFocus );
            label.setBorder ( border );
            return label;
        }
    } );
    frame.add ( tree );

    frame.pack ();
    frame.setLocationRelativeTo ( null );
    frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
    frame.setVisible ( true );
}