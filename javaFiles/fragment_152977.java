myButton.addMouseListener(new MouseListener()
    {

    public void mouseClicked(MouseEvent e)
    {
    }

    public void mousePressed(MouseEvent e)
    {
    }

    public void mouseReleased(MouseEvent e)
    {
      if(clickAlphaValue(((myButton)e.getSource()).getBufImg(), e.getX(), e.getY()) != 0) //If alpha is not set to 0
        System.exit(0); //Or other things you want your button to do
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
    }
  });