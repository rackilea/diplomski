final  boolean [] pause = new boolean []{false};
  Runnable r = new Runnable()
{
     public void run()
     {
         while(true)
         {
             if(!pause[0])
             window1.paintImage();//fn to redraw an image
         }
     }
};

...

public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_P)
        {
            if(!pause[0])
            {
                pause[0] = true;
            } else
            {
                pause[0] = false;
            }
        }
    }