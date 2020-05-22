public class TestPane extends JPanel implements PaintContainer {

    private Set<Kulka> entities;

    public TestPane() {
        entities = new HashSet<>(10);
        for (int index = 0; index < 10; index++) {
            float degrees = (float)(Math.random() * 359d);
            float delta = (float)((Math.random() * 10d) - 5d);
            Kulka kulka = new Kulka(this, degrees, delta);
            entities.add(kulka);
            Updater updater = new Updater(kulka);
            updater.start();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    @Override
    synchronized protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int diameter = Math.min(getWidth(), getHeight());
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;

        g2d.setColor(Color.GREEN);
        g2d.drawOval(x, y, diameter, diameter);

        g2d.setColor(Color.RED);
        g2d.dispose();

        for (Kulka kulka : entities) {
            g2d = (Graphics2D) g.create();
            kulka.paint(g2d);
            g2d.dispose();
        }
    }

    @Override
    synchronized public void wasUpdated(Kulka kulka) {
        repaint();
    }

}