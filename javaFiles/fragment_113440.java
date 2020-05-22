public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_G && !(myWindow.getFocusOwner() instanceof TextField))
        {
            showDialog();
        }
    }