class MyImageIcon extends ImageIcon
    {
    public MyImageIcon(Image img)
      {
      super(img);
      }
   public  void paintIcon(Component c, Graphics g, int x, int y)
     {
     super.paintIcon(c,g,x,y);
     g.drawLine(0,0,10,10);// .... paint your mark here
     }
    };