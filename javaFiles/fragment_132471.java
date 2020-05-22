private class HandlerClass implements MouseListener
  {
    public void mouseClicked(MouseEvent event)
    {
      if(event.getSource()==lb1)
      {
        if(j==1)
          x[1]=1;
        else
          x[1]=2;
        lb1.setIcon(icon);
      }

      Horizon.this.checkWinner(); 

      if(i==9)
      {
        JOptionPane.showMessageDialog(null, "The game is a draw", "Draw", JOptionPane.OK_OPTION);
      }
    }

    public void mousePressed(MouseEvent event){}
    public void mouseEntered(MouseEvent event){}
    public void mouseReleased(MouseEvent event){}
    public void mouseExited(MouseEvent event){} // error here
  }