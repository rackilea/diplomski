public void drawRectangle(double x, double y, int xs, int ys, int colour){
    if(xs <= 0)
        return;

    g2d.setColor(new Color(colour));
    g2d.fillRect((int)(x-xScroll), (int)(y-yScroll), xs, ys);
}