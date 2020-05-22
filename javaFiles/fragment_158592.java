import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BoundaryFillAlgorithm {
public static BufferedImage toFill = MemoryPanel.Crect;
Graphics g1 = toFill.getGraphics();     

public BoundaryFillAlgorithm(BufferedImage toFill){
    int x = toFill.getWidth()/2-10;
    int y = toFill.getHeight()/2;
    int old = toFill.getRGB(x, y);
    this.toFill = toFill;
    fill(x,y,old);  
}

private void fill(int x,int y,int old) {
    if(x<=0) return;
    if(y<=0) return;
    if(x>=toFill.getWidth()) return;
    if(y>=toFill.getHeight())return;

    if(toFill.getRGB(x, y)!=old)return;
    toFill.setRGB(x, y, 0xFFFF0000);
    fill(x+1,y,old);
    fill(x,y+1,old);
    fill(x-1,y,old);
    fill(x,y-1,old);
    fill(x+1,y-1,old);
    fill(x+1,y+1,old);
    fill(x-1,y-1,old);
    fill(x+1,y-1,old);

}