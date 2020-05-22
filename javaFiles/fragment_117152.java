import java.awt.Color;
    import java.awt.Graphics;
    import javax.swing.JPanel;
    import javax.swing.JFrame;

    public class RectTest {
     DrawPanel panel;
     int x;
     int y;
     public static void main(String[] args) {
      new RectTest().startApp();
     } 

     public void startApp() {
      panel = new DrawPanel();
      JFrame app = new JFrame();
      app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
      //modify this line
      app.getContentPane().add(panel);
      app.setSize(450, 250);
      app.setVisible(true);
      //added for loop here
      for (int i = 0; i < 10; i++ ) {
       // x,y here
       x = 10+5*i;
       y = 10+5*i;
       // repaint the panel
       panel.repaint();
       // wait 2sec
       try{
          Thread.sleep( 2000 );
       }
       catch (InterruptedException ex) { }
    }
   }

   class DrawPanel extends JPanel {
    public void paintComponent( Graphics g) {
       //super.paintComponent(g);
       // repaint the backround to see the single reactangles
       g.setColor(Color.white);
       g.fillRect(0, 0, this.getWidth(), this.getHeight());

       g.setColor(Color.green);
       g.drawRect(x, y, 20, 20);
    }
   }
  }