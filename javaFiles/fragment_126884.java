class MyPanel extends JPanel {
       Boolean drawBlue = false;

    public void drawBlueCircle( Boolean draw ) {
       drawBlue = draw;
       repaint();
    }

    protected void paintComponent( Graphics g ) {
       if ( drawBlue ) {
          g.setColor(Color.BLUE);
          g.fillOval(200, 200, 400, 50);
       }
     }
}