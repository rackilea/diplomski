public class GraphicsFoo extends JPanel {
   // avoid using magic numbers:
   private static final int CIRCLE_DIAMETER = 50; 

   //....

   // override a JComponent's paintComponent method, not its paint method
   @Override
   protected void paintComponent(Graphics g) {
       super.paintComponent(g);

       Graphics2D g2d = (Graphics2D) g;
       g2d.setBackground(Color.white);

       // make your graphics smooth
       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
             RenderingHints.VALUE_ANTIALIAS_ON);

       // ...

       final double cosTheta = Math.cos(theta);
       final double sinTheta = Math.sin(theta);

       for (int distance = xFrom; distance <= len; distance += interval)
       {

           //....

           // *** here's the key: ***    
           g2d.drawOval(
              x_circle_pixel - CIRCLE_DIAMETER / 2, 
              y_circle_pixel - CIRCLE_DIAMETER / 2, 
              CIRCLE_DIAMETER, CIRCLE_DIAMETER);

           g2d.setColor(Color.BLUE);

       }