glassPane.setFocusable(true);
    glassPane.addKeyListener(new KeyListener()
    {
        @Override
        public void keyTyped(KeyEvent e)
        {
            e.consume();
        }

        @Override
        public void keyReleased(KeyEvent e)
        {
            e.consume();
        }

        @Override
        public void keyPressed(KeyEvent e)
        {
            e.consume();
        }
    });