public class MergeImages {

    public static void main(String[] args) {
        File inner = new File("Inner.png");
        File outter = new File("Outter.png");

        try {

            BufferedImage biInner = ImageIO.read(inner);
            BufferedImage biOutter = ImageIO.read(outter);

            System.out.println(biInner);
            System.out.println(biOutter);

            Graphics2D g = biOutter.createGraphics();
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
            int x = (biOutter.getWidth() - biInner.getWidth()) / 2;
            int y = (biOutter.getHeight() - biInner.getHeight()) / 2;
            System.out.println(x + "x" + y);
            g.drawImage(biInner, x, y, null);
            g.dispose();

            ImageIO.write(biOutter, "PNG", new File("Outter.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}