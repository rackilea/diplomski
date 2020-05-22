public class Cords{


    public void paint(Graphics g, int w, int h, int n)
    {
        for(int xC = 0; xC <=w; xC += n){
            g.drawLine(xC,11,xC,h);
            g.drawString(""+xC,xC-(n/5),11);
        }
        for(int yC = 0; yC <= h; yC += n){
            g.drawLine(25,yC,w,yC);
            g.drawString(""+yC,1,yC+((n/5)/2));
        }
    }
}