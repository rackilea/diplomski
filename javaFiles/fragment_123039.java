JPanel panel = new JPanel ();
    panel.addComponentListener ( new ComponentAdapter ()
    {
        public void componentShown ( ComponentEvent e )
        {
            System.out.println ( "Component shown" );
        }

        public void componentHidden ( ComponentEvent e )
        {
            System.out.println ( "Component hidden" );
        }
    } );