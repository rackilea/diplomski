glassPane.addMouseListener(new MouseAdapter()
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            e.consume();
        }

        @Override
        public void mousePressed(MouseEvent e)
        {
            e.consume();
        }
    });