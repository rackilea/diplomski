//only called on time by applet system
public void init() {
  setForeground ( vordergrundfarbe);
  setBackground ( hintergrundfarbe); 
}
//called everytime you call repaint()
public void paint( Graphics g)
{
  g.drawString("Hello World...",50,50); // Bildschirmausschrift erzeugen
}