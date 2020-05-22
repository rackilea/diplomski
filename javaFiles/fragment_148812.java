public static void main ( String[] args )
{
    JFrame frame = new JFrame ();

    LogoLayout layout = new LogoLayout ();
    frame.setLayout ( layout );

    frame.add ( new JLabel ( "Label with same preferred size as text length" )
    {
        protected void paintComponent ( Graphics g )
        {
            super.paintComponent ( g );

            g.setColor ( Color.BLACK );
            g.drawLine ( 0, 0, getWidth (), getHeight () );
            g.drawLine ( getWidth (), 0, 0, getHeight () );
        }
    }, layout.CONTENT );

    frame.add ( new JComponent ()
    {
        protected void paintComponent ( Graphics g )
        {
            g.setColor ( Color.BLACK );
            g.drawLine ( 0, 0, getWidth (), getHeight () );
            g.drawLine ( getWidth (), 0, 0, getHeight () );
        }

        public Dimension getPreferredSize ()
        {
            return new Dimension ( 100, 100 );
        }
    }, layout.LOGO );

    frame.setSize ( 700, 500 );
    frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
    frame.pack ();
    frame.setLocationRelativeTo ( null );
    frame.setVisible ( true );
}

public static class LogoLayout implements LayoutManager
{
    public String CONTENT = "Content";
    public String LOGO = "Logo";

    private Map<Component, String> constraints = new HashMap<Component, String> ();

    public void addLayoutComponent ( String name, Component comp )
    {
        constraints.put ( comp, name );
    }

    public void removeLayoutComponent ( Component comp )
    {
        constraints.remove ( comp );
    }

    public void layoutContainer ( Container parent )
    {
        Insets bi = parent.getInsets ();
        int contentSize = 0;
        int logoSize = 0;
        int maxHeight = 0;
        for ( Component component : parent.getComponents () )
        {
            Dimension ps = component.getPreferredSize ();
            if ( constraints.get ( component ).equals ( CONTENT ) )
            {
                contentSize = Math.max ( ps.width, contentSize );
            }
            else if ( constraints.get ( component ).equals ( LOGO ) )
            {
                logoSize = Math.max ( ps.width, logoSize );
            }
            maxHeight = Math.max ( ps.height, maxHeight );
        }

        int width = parent.getWidth () - bi.left - bi.right;
        int height = parent.getHeight () - bi.top - bi.bottom;
        for ( Component component : parent.getComponents () )
        {
            if ( constraints.get ( component ).equals ( CONTENT ) )
            {
                if ( contentSize + logoSize < width )
                {
                    component.setBounds ( bi.left, bi.top, width - logoSize, height );
                }
                else
                {
                    component.setBounds ( bi.left, bi.top, contentSize, height );
                }
            }
            else if ( constraints.get ( component ).equals ( LOGO ) )
            {
                if ( contentSize + logoSize < width )
                {
                    component
                            .setBounds ( bi.left + width - logoSize, bi.top, logoSize, height );
                }
                else
                {
                    int scaledLogoSize = width - contentSize;
                    if ( scaledLogoSize > 0 )
                    {
                        component.setBounds ( bi.left + width - scaledLogoSize, bi.top,
                                scaledLogoSize, height );
                    }
                }
            }
        }
    }

    public Dimension preferredLayoutSize ( Container parent )
    {
        Insets bi = parent.getInsets ();
        int contentSize = 0;
        int logoSize = 0;
        int maxHeight = 0;
        for ( Component component : parent.getComponents () )
        {
            Dimension ps = component.getPreferredSize ();
            if ( constraints.get ( component ).equals ( CONTENT ) )
            {
                contentSize = Math.max ( ps.width, contentSize );
            }
            else if ( constraints.get ( component ).equals ( LOGO ) )
            {
                logoSize = Math.max ( ps.width, logoSize );
            }
            maxHeight = Math.max ( ps.height, maxHeight );
        }
        return new Dimension ( bi.left + contentSize + logoSize + bi.right,
                bi.top + maxHeight + bi.bottom );
    }

    public Dimension minimumLayoutSize ( Container parent )
    {
        return preferredLayoutSize ( parent );
    }
}