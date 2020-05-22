public void paintComponent(Graphics g)
{
    super.paintComponent(g); // **** add this
    // Moving Rectangle
    g.setColor(Color.RED);
    g.fillRect(a ,300, 1 ,30);
    // tm.start(); // **** get rid of this.
}