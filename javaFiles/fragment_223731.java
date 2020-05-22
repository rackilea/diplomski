public class MyMenuBar extends JMenuBar {

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);

    }

}