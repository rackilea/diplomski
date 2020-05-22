import java.awt.*;
import javax.swing.*;

public class Stereonet{

  private static int centreX, centreY, radius;
  private Color colour;

  /**Stereonet template contructor takes 3 int parameters 
    * x, y for centre position and radius for stereonet radius*/
  public Stereonet(int x , int y, int radius, Color colour){

    centreX = x;
    centreY = y;
    this.radius = radius;
    this.colour = colour;

  }

    public void draw(Graphics g){

      Graphics2D g2D = (Graphics2D) g;           
      g2D.setStroke(new BasicStroke(2F));  
      g.setColor(colour);
      g.drawOval(centreX - radius , centreY - radius, radius * 2 , radius * 2);
      g2D.setStroke(new BasicStroke(1F)); 
      g.drawLine(centreX, centreY - radius, centreX, centreX + radius);
      g.drawLine(centreX - radius, centreY, centreX + radius, centreY);

      g2D.setStroke(new BasicStroke(1F));

      for(int degrees = 10; degrees <= 80; degrees += 10){


        double greatRadius = radius / (Math.cos(Math.toRadians(degrees))); // radius of great circle
        int greatX1 = (int)Math.round(centreX + radius * (Math.tan(Math.toRadians(degrees))) 
                                        - greatRadius); // x coord of great circle left hemisphere
        int greatX2 = (int)Math.round(centreX - (radius * (Math.tan(Math.toRadians(degrees)))) 
                                        - greatRadius); // x coord of great circle right hemisphere
        int greatY = (int)Math.round(centreY - greatRadius); // y coord of great circle

        double smallRadius = (radius / (Math.tan(Math.toRadians(degrees))));
        int smallY1 = (int)Math.round((centreY  - (radius / (Math.sin(Math.toRadians(degrees)))) - smallRadius));
        int smallY2 = (int)Math.round((centreY  + (radius / (Math.sin(Math.toRadians(degrees)))) - smallRadius));
        int smallX = (int)Math.round(centreX - smallRadius);

        g.drawArc(greatX1, greatY, 2 * (int)Math.round(greatRadius), 2 * (int)Math.round(greatRadius), 
                  90 + degrees, 180 - ( 2 * degrees));
        g.drawArc(greatX2, greatY, 2 * (int)Math.round(greatRadius), 2 * (int)Math.round(greatRadius), 
                  270 + degrees, 180 - ( 2 * degrees));
        g.drawArc(smallX, smallY1, 2 * (int)Math.round(smallRadius), 2 * (int)Math.round(smallRadius), 
                  270 - degrees, 180 - ( 2 * (90 - degrees)));
        g.drawArc(smallX, smallY2, 2 * (int)Math.round(smallRadius), 2 * (int)Math.round(smallRadius), 
                  90 - degrees, 180 - ( 2 * (90 - degrees)));  

      }

    }

    public static int getRadius(){

      return radius;

    }  

    public static int getX(){

      return centreX;

    }  

     public static int getY(){

      return centreY;

    }