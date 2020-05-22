public class MyPanel extends JPanel{
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawRect(10/*x*/, 10/*y*/, 80/*width*/, 30/*hight*/);
    g.drawString("TextToDraw", 25/*x*/, 25/*y*/);
  }
}