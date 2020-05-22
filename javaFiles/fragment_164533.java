/**
 * draws a blue circle and sets the tlX and tlY for the next drawing
 * @param g Graphics object
 * @return 
 */
public Coord drawCircle(Graphics g) throws InterruptedException
{
    g.setColor(Color.blue);
    g.drawOval(tlX,tlY,size,size);
    delay(timeDelay);
    if (addX)
        tlX+=incX;
    else
        tlX-=incX;
    if (addY)
        tlY+=incY;
    else
        tlY-=incY;
    return new Coord(tlX, tlY);
}