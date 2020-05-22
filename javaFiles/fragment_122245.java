public void paint(Graphics g) 
  {
    X=getX();
    Y=getY();
    W=getWidth();
    H=getHeight();
    g.drawImage(image,0,0,W,H,X,Y,X+W,Y+H,this);
    Record_Button.repaint();         // This will fix it
  }