boolean shiftIsDown = false;

yourJGrid.addKeyListener(new KeyListener()
        {
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyCode == e.VK_SHIFT) shiftIsDown = true; 
            }

            public void keyReleased(KeyEvent e)
            {
                 if (e.getKeyCode == e.VK_SHIFT && 
                     shiftIsDown == true) shiftIsDown = false;
            }

            public void keyTyped(KeyEvent e)
            {
                // nothing
            }

        });