public void paintComponent(Graphics g)
{
    Graphics2D g2d = (Graphics2D) g;
    g2d.translate(0, -height);
    g2d.scale(1.0, -1.0);
    //draw your component with the new coordinates

    //you may want to reset the transforms at the end to prevent
    //other controls from making incorrect assumptions
    g2d.scale(1.0, -1.0);
    g2d.translate(0, height);
}