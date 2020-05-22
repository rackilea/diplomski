public class TestPane extends JPanel {

    public TestPane() {

        setBorder(new LineBorder(Color.RED));
        // This is for demonstration purposes only
        // One should always rely on the layout manager
        // to define this value
        // Thank kleopatra 
        setPreferredSize(new Dimension(1000, 1000));

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        FontMetrics fm = g.getFontMetrics();

        Dimension size = getPreferredSize();
        String text = "Pref: " + size.width + "x" + size.height;
        g.drawString(text, 0, fm.getAscent());

        size = getSize();
        text = "Size: " + size.width + "x" + size.height;
        g.drawString(text, 0, fm.getHeight() + fm.getAscent());

    }

}