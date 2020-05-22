import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;


public class Game extends Applet
{
    boolean left  = false;
    boolean right = false;
    int platPos = 0;


    @Override
     public void paint(Graphics g) 
    {
         g.fillRect(50+platPos, 0, 100, 20); 
         System.out.println("repaint");
         if(left)
         {

             g.setColor(new Color(255,255,255)); //sets color to white
             g.fillRect(50+platPos, 0, 100, 20); //draws over whatever existing rectangle there is with white
             platPos--; 
             g.setColor(new Color(100,100,100)); //sets new color
             g.fillRect(50+platPos,0, 100,20); //draws new rectangle 
             left = false; 
         }

         if(right)
         {
             g.setColor(new Color(255,255,255));
             g.fillRect(50+platPos,200,100,20);
             platPos++;
             g.setColor(new Color(100,100,100));
             g.fillRect(50+platPos,200,100,20);
             right = false;
         }

    }
    @Override
    public boolean keyDown(Event e, int key) 
    {
             if (key == Event.LEFT) {
                left = true;
             }

            if (key == Event.RIGHT) {
                right = true;
            }

            repaint();
            return true;
     }
}