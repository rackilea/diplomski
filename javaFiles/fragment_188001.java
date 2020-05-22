public class ColorCheckBox extends JCheckBox {

    public ColorCheckBox(Color unselectedColor, Color selectedColor) {
        setSelectedIcon(icon(Color.MAGENTA));
        setIcon(icon(Color.WHITE));
    }

    protected Icon icon(Color filled) {
        BufferedImage img = new BufferedImage(25, 25, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(filled);
        g2d.fillRect(0, 0, 25, 25);
        g2d.dispose();
        return new ImageIcon(img);
    }

}