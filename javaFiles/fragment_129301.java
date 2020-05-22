@Override
public void paint(Graphics g) {
   super.paint(g);
   if (drawLine) {
      g.drawLine(0, 100, 100, 10);
   } else if (drawRect) {
      g.drawRect(10, 10, 60, 50);
   } else {
      g.drawOval(10, 10, 50, 50);
   }
}