@Override
protected void paintComponent(Graphics g)
     Graphics2D g2d = (Graphics2D)g;
     g2d.setColor(Color.grey);
     g2d.fillRect(0,0,this.getWidth(),this.getHeight()); //<-- clear the background
     for (Shape i : myArr)
     {
        g2d.draw(i);
     }   
  }