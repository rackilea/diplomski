@Override
protected void paintComponent(Graphics g)
{
    super.paintComponent(g);

    //Graphics2D ga = (Graphics2D) g;
    Graphics2D ga =  (Graphics2D)g.create();

    ga.translate(175.0, 125.0); //the mouse coordinates stop displaying with this code
    ga.drawLine(0, 0, 100, 100);

    ga.dispose();
}