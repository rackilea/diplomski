public class OurMain {

    public static void main(String[] args) {
        Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
        int w = sSize.width;
        Random random = new Random();
        int x = random.nextInt();
        int y = random.nextInt();
        JFrame f = new MyFrame(w / 3, 100, x, y); //my errors are underlined here under the x and y
        f.setVisible(true);
    }
}