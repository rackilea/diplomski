public class TestPane extends JPanel {

    private List<Circle> circles = new ArrayList<>(10);
    private Dimension size;

    public TestPane() {
        Random random = new Random();
        int maxX = 0;
        int maxY = 0;
        for (int index = 0; index < 10; index++) {
            int randX = random.nextInt(250) + 50;
            int randY = random.nextInt(250) + 50;
            circles.add(new Circle(randX, randY, 25));

            maxX = Math.max(maxX, randX + 50);
            maxY = Math.max(maxY, randY + 50);
        }
        size = new Dimension(maxX, maxY);
    }

    @Override
    public Dimension getPreferredSize() {
        return size;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Circle circle : circles) {
            Graphics2D g2d = (Graphics2D) g.create();
            circle.paint(g2d);
            g2d.dispose();
        }
    }

}