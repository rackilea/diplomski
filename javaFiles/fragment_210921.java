@Override
  public void paintComponent(Graphics g)
  {
      super.paintComponent( g );
    for (int f=0;f<font_type.length;f++)
    {
      for (int s=0;s<styles.length;s++)
      {
        Font font=new Font(font_type[f],styles[s],18);
        g.setFont(font);
        String name=font_type[f]+" "+stylenames[s];
//        g.drawString(name,20,(f*4+s+1)*20);
        g.drawString(name,20,(f+s+1)*20);
      }
    }
  }