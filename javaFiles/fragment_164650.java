/**
 * Draw the names under the bars
 * @author Kay van Bree
 * @param g 
 */
private void drawName(Graphics g, String name, int x){
    Graphics2D g2d = (Graphics2D) g.create();

    // Rotate
    g2d.rotate(Math.PI/2.0, x + (barWidth/4), bottom + 3);

    // Print
    g2d.setColor(Color.BLACK);
    g2d.drawString(name, (int) (x + (barWidth/4)), (int) bottom  + 3);

    // Reset transformation
    g2d.dispose();
}