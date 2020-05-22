import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
public class CircleButton extends JButton {

 // Graphics g = this.getGraphics();
 Color col = Color.pink;
  public CircleButton(){
   //commented as unuseful.. super call is implicit if constructor has no arguments
   // super();
    setContentAreaFilled(false);
  }

  protected void paintComponent(Graphics g) {
   g.setColor(this.color);
   g.fillOval(0, 0, getSize().width-1, getSize().height-1);
   super.paintComponent(g);
}

  public void changeColor(Color c) {
      this.color = Color.blue; //only change the color. Let paintComponent paint
      this.repaint();
  }                        
}