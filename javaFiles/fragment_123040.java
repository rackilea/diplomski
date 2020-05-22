JPanel panel = new JPanel ();
    panel.addAncestorListener ( new AncestorListener ()
    {
        public void ancestorAdded ( AncestorEvent event )
        {
            // Component added somewhere
        }

        public void ancestorRemoved ( AncestorEvent event )
        {
            // Component removed from container
        }

        public void ancestorMoved ( AncestorEvent event )
        {
            // Component container moved
        }
    } );