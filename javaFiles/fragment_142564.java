public class HashtagLikeDisplay extends JComponent{
...

protected void paintComponent(Graphics g) {
super.paintComponent(g);
// Customize after calling super.paintComponent(g)

Font font = getFont().deriveFont(48f);
g.setFont(font);
g.setColor(Color.RED);
String message = "Total: " + Integer.toString(count);
g.drawString(message, 10, 58);