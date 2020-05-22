public class Form1 extends JApplet {
    Image i;

    public void init() {
        try {
            i = ImageIO.read(new URL(getCodeBase(), "test.bmp"));
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        g.drawImage(i, 0, 0, null);
    }
}