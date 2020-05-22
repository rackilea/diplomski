@Override
protected void paintComponent(Graphics g) {
     super.paintComponent(g);// <-- let panel draw itself
     Graphics2D g2d = (Graphics2D)g;
     for (Shape i : myArr)
     {
        g2d.draw(i);
     }   
  }