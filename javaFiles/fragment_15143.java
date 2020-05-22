public class TestPane extends JPanel {

    JButton left;
    JButton right;
    JPanel paintPane;

    private DefaultShapeModel model;

    public TestPane() {
        model = new DefaultShapeModel();

        JButton left = new JButton("left");
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Point p = model.getPoint();
                p.x--;
                if (p.x > 0) {
                    p.x = 0;
                }
                model.setPoint(p);
            }
        });
        JButton right = new JButton("right");
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point p = model.getPoint();
                p.x++;
                if (p.x + 40 > paintPane.getWidth()) {
                    p.x = paintPane.getWidth() - 40;
                }
                model.setPoint(p);
            }
        });

        paintPane = new PaintPane(model);

        setLayout(new BorderLayout());
        add(left, BorderLayout.WEST);
        add(right, BorderLayout.EAST);
        add(paintPane);
    }

}

public class PaintPane extends JPanel {

    private ShapeModel model;

    public PaintPane(ShapeModel model) {
        this.model = model;
        this.model.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                repaint();
            }
        });
    }

    public ShapeModel getModel() {
        return model;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D g1 = (Graphics2D) g;
        Point p = getModel().getPoint();
        g1.fillOval(p.x, p.y, 40, 40);
        g1.setColor(Color.WHITE);
        g1.drawOval(p.x, p.y, 40, 40);

    }
}