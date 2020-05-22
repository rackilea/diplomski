public class OurMain {

    public static void main(String[] args) {
        Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = sSize.width;
        int h = sSize.height;

        Random rand1 = new Random();

        int randomWidth = rand1.nextInt(w);
        int randomHeight = rand1.nextInt(h);

        Random rand2 = new Random(); // I would still use rand1

        int randomX = rand2.nextInt(w - randomWidth + 1);
        int randomY = rand2.nextInt(h - randomHeight + 1);

        JFrame f = new MyFrame(randomWidth, randomHeight, randomX, randomY);
        f.setVisible(true);
    }
}