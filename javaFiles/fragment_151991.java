public class Form1 extends JApplet {
    public void paint(Graphics g) {
        Image i = ImageIO.read(new URL(getCodeBase(), "fileName.bmp"));
        g.drawImage(i,0,0,WIDTH,HEIGHT,Color.White,null);
    }
}