public void mouseMoved(MouseEvent me)  
    {
       ...
       if (xpos > x&& xpos < x+width && ypos > y && ypos < y+height)  
       {
           active = true;
           //here
           x=(int)(Math.random() * 401);
           y=(int)(Math.random() * 401);
       } 
       else  
           ...
    }