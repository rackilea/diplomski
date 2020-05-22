public class Rect extends JComponent {

      private static final long serialVersionUID = 1L;
      private static final int PREF_W = 150;
      private static final int PREF_H = 150;

      @Override
      // public void paint(Graphics g) {
      protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.setColor(Color.black);
         g.drawRoundRect(10, 10, 100, 100, 20, 20);
      }

      @Override
      public Dimension getPreferredSize() {
         return new Dimension(PREF_W, PREF_H);
      }
   }