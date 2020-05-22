public static void drawRectangle(Graphics g, int size, String cord_x, String cord_y) {
    int longside = size / 4;
    int shortside = size / 8;
    int x = 0;
    int y = 0;
    if(cord_x.equals("top")) {  
        if(cord_y.equals("right"))
        {
           x = size-(size/3);
           y = size/8;
        }
        else
        {
           if(cord_y.equals("left"))
           {
               x = size/12;
               y = size/8;
           }
        }
    }
    else
    {

        if(cord_x.equals("bottom")) {  
           if(cord_y.equals("right"))
           {
              x = size-(size/3);
              y = size-(size/4);
           }
           else
           {
              if(cord_y.equals("left"))
              {
                 x =  size/12;
                y = size-(size/4);
              }
           }
        }
    }
    g.drawRect(x, y, longside, shortside);

}