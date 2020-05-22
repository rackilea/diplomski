public void draw( Graphics g )
   {          
      g.setColor( getMyColor() );
      if(filled)
         g.fillRect(getX1(), getY1(), getWidth(), getHeight());
      else
         g.drawRect(getX1(), getY1(), getWidth(), getHeight());
   } // end method draw