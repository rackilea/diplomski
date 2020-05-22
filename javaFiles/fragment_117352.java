private class Key
    implements KeyListener
{
    private boolean spacebarPressed = false;

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            spacebarPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            spacebarPressed = false;
        }
    }

    public boolean isSpacebarPressed()
    {
        return spacebarPressed;
    }
}