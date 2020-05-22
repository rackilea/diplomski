public class TestPane extends BackgroundImagePane {

    public TestPane() throws IOException {

        super(ImageIO.read(new File("Path/to/your/image")));            

        Random rnd = new Random();

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        JPasswordField pf = new JPasswordField(10);
        JButton btn = new JButton("Login");
        panel.add(pf);
        panel.add(btn);

        setLayout(new RandomLayoutManager());

        Dimension size = getPreferredSize();
        size.width -= panel.getPreferredSize().width;
        size.height -= panel.getPreferredSize().height;

        add(panel, new Point(rnd.nextInt(size.width), rnd.nextInt(size.height)));

    }

}

public class RandomLayoutManager implements LayoutManager2 {

    private Map<Component, Point> mapConstraints;

    public RandomLayoutManager() {
        mapConstraints = new WeakHashMap<>(25);
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        mapConstraints.remove(comp);
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        Area area = new Area();
        for (Component comp : mapConstraints.keySet()) {

            Point p = mapConstraints.get(comp);
            Rectangle bounds = new Rectangle(p, comp.getPreferredSize());
            area.add(new Area(bounds));

        }

        Rectangle bounds = area.getBounds();
        Dimension size = bounds.getSize();
        size.width += bounds.x;
        size.height += bounds.y;

        return size;

    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return preferredLayoutSize(parent);
    }

    @Override
    public void layoutContainer(Container parent) {
        for (Component comp : mapConstraints.keySet()) {
            Point p = mapConstraints.get(comp);
            comp.setLocation(p);
            comp.setSize(comp.getPreferredSize());
        }
    }

    @Override
    public void addLayoutComponent(Component comp, Object constraints) {
        if (constraints instanceof Point) {

            mapConstraints.put(comp, (Point) constraints);

        } else {

            throw new IllegalArgumentException("cannot add to layout: constraint must be a java.awt.Point");

        }
    }

    @Override
    public Dimension maximumLayoutSize(Container target) {
        return preferredLayoutSize(target);
    }

    @Override
    public float getLayoutAlignmentX(Container target) {
        return 0.5f;
    }

    @Override
    public float getLayoutAlignmentY(Container target) {
        return 0.5f;
    }

    @Override
    public void invalidateLayout(Container target) {
    }

}

public class BackgroundImagePane extends JPanel {

    private Image image;

    public BackgroundImagePane(Image img) {

        this.image = img;

    }

    @Override
    public Dimension getPreferredSize() {
        return image == null ? super.getPreferredSize() : new Dimension(image.getWidth(this), image.getHeight(this));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            int x = (getWidth() - image.getWidth(this)) / 2;
            int y = (getHeight() - image.getHeight(this)) / 2;
            g.drawImage(image, x, y, this);
        }
    }

}