public void keyPressed(KeyEvent e) 
{
    int keyCode = e.getKeyCode();
    if(keyCode == KeyEvent.VK_RIGHT)
    {
        keyboadrRightPressed = true;
    }
    else
    {
        keyboadrRightPressed = false;
    }
    repaint();
}