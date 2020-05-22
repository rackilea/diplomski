Graphics2D g2d ;

String s = "hello\nworld";
int x = 0, y = 0;
String[] lines = s.split("\\n");
for(int i=0,l = lines.length;i<l;i++) {
    String curLine = lines[i].trim();
    FontMetrics fm = g2d.getFontMetrics();
    Rectangle2D r = fm.getStringBounds(curLine, g2d);
    g2d.drawString(curLine, x, y);
    y += r.getHeight() + fm.getAscent();    
}