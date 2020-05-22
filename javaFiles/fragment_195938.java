class GUI extends JFrame {

    public static void main(String[] args) {

        new GUI();
    }

    public GUI() {

        JTabbedPane mainTabs = new JTabbedPane();
        JTabbedPane linTabs = new JTabbedPane();
        JTabbedPane radTabs = new JTabbedPane();
        JButton button;
        Point2D start, end;
        float[] dist;
        Color[] colors;
        BasicStroke stroke;

        start = new Point2D.Float(0, 0);
        end = new Point2D.Float(500, 500);
        dist = new float[] {0.0f, 0.2f, 1.0f};
        colors = new Color[] {Color.RED, Color.WHITE, Color.BLUE};
        LinearGradientPaint lgp;
        stroke = new BasicStroke(5);
/// Linear ///
        button = new JButton("Button");
        lgp = new LinearGradientPaint(start, end, dist, colors);
        button.setBorder(BorderFactory.createStrokeBorder(stroke, lgp));
        linTabs.addTab("Red-White-Blue 5", button);

        button = new JButton("Button");
        end = new Point2D.Float(200, 200);
        lgp = new LinearGradientPaint(start, end, dist, colors, CycleMethod.REFLECT);
        button.setBorder(BorderFactory.createStrokeBorder(stroke, lgp));
        linTabs.addTab("Red-White-Blue Reflect 5", button);

        button = new JButton("Button");
        end = new Point2D.Float(500, 500);
        lgp = new LinearGradientPaint(start, end, dist, colors, CycleMethod.REPEAT);
        button.setBorder(BorderFactory.createStrokeBorder(stroke, lgp));
        linTabs.addTab("Red-White-Blue Repeat 5", button);

        stroke = new BasicStroke(20);
        button = new JButton("Button");
        button.setBorder(BorderFactory.createStrokeBorder(stroke, lgp));
        linTabs.addTab("Red-White-Blue 20", button);

        button = new JButton("Button");
        end = new Point2D.Float(200, 200);
        lgp = new LinearGradientPaint(start, end, dist, colors, CycleMethod.REFLECT);
        button.setBorder(BorderFactory.createStrokeBorder(stroke, lgp));
        linTabs.addTab("Red-White-Blue Reflect 20", button);

        button = new JButton("Button");
        end = new Point2D.Float(500, 500);
        lgp = new LinearGradientPaint(start, end, dist, colors, CycleMethod.REPEAT);
        button.setBorder(BorderFactory.createStrokeBorder(stroke, lgp));
        linTabs.addTab("Red-White-Blue Repeat 20", button);

        dist = new float[] {0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1f};
        colors = new Color[] {Color.RED, Color.ORANGE, Color.YELLOW, Color.LIGHT_GRAY,
                                Color.BLACK, Color.RED};
        stroke = new BasicStroke(5);

        button = new JButton("Button");
        lgp = new LinearGradientPaint(start, end, dist, colors);
        button.setBorder(BorderFactory.createStrokeBorder(stroke, lgp));
        linTabs.addTab("Dark 5", button);

        button = new JButton("Button");
        end = new Point2D.Float(200, 200);
        lgp = new LinearGradientPaint(start, end, dist, colors, CycleMethod.REFLECT);
        button.setBorder(BorderFactory.createStrokeBorder(stroke, lgp));
        linTabs.addTab("Dark Reflect 5", button);

        button = new JButton("Button");
        end = new Point2D.Float(500, 500);
        lgp = new LinearGradientPaint(start, end, dist, colors, CycleMethod.REPEAT);
        button.setBorder(BorderFactory.createStrokeBorder(stroke, lgp));
        linTabs.addTab("Dark Repeat 5", button);

        stroke = new BasicStroke(20);
        button = new JButton("Button");
        button.setBorder(BorderFactory.createStrokeBorder(stroke, lgp));
        linTabs.addTab("Dark 20", button);

        button = new JButton("Button");
        end = new Point2D.Float(200, 200);
        lgp = new LinearGradientPaint(start, end, dist, colors, CycleMethod.REFLECT);
        button.setBorder(BorderFactory.createStrokeBorder(stroke, lgp));
        linTabs.addTab("Dark Reflect 20", button);

        button = new JButton("Button");
        end = new Point2D.Float(500, 500);
        lgp = new LinearGradientPaint(start, end, dist, colors, CycleMethod.REPEAT);
        button.setBorder(BorderFactory.createStrokeBorder(stroke, lgp));
        linTabs.addTab("Dark Repeat 20", button);
/// Radial ///
        Point2D center = new Point2D.Float(20, 20);
        float radius = 1;
        dist = new float[] {0.0f, 0.2f, 1.0f};
        colors = new Color[] {Color.RED, Color.WHITE, Color.BLUE};
        RadialGradientPaint  rgp;
        stroke = new BasicStroke(40);

        button = new JButton("Button");
        rgp = new RadialGradientPaint(center, radius, dist, colors, CycleMethod.REPEAT);
        button.setBorder(BorderFactory.createStrokeBorder(stroke, rgp));
        radTabs.addTab("{Red, Blue White} assymetric 40", button);

        button = new JButton("Button");
        radius = 300;
        stroke = new BasicStroke(10);
        center = new Point2D.Float(500, 250);
        rgp = new RadialGradientPaint(center, radius, dist, colors, CycleMethod.REPEAT);
        button.setBorder(BorderFactory.createStrokeBorder(stroke, rgp));
        radTabs.addTab("{Red, Blue White} REPEAT 40", button);

        button = new JButton("Button");
        radius = 150;
        rgp = new RadialGradientPaint(center, radius, dist, colors, CycleMethod.REFLECT);
        button.setBorder(BorderFactory.createStrokeBorder(stroke, rgp));
        radTabs.addTab("{Red, Blue White} Reflect 40", button);

        colors = new Color[] {Color.PINK, Color.MAGENTA, Color.BLUE, Color.CYAN, Color.GREEN, Color.PINK};
        dist = new float[] {0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1f};

        button = new JButton("Button");
        radius = 70;
        Point2D focus = new Point2D.Float(40, 90);
        rgp = new RadialGradientPaint(center, radius, focus, dist, colors, CycleMethod.REFLECT);
        button.setBorder(BorderFactory.createStrokeBorder(stroke, rgp));
        radTabs.addTab("Light Reflect assymetric", button);

        button = new JButton("Button");
        rgp = new RadialGradientPaint(center, radius, focus, dist, colors, CycleMethod.REPEAT);
        button.setBorder(BorderFactory.createStrokeBorder(stroke, rgp));
        radTabs.addTab("Light Repeat assymetric", button);

        button = new JButton("Button");
        radius = 70;
        stroke = new BasicStroke(10);
        center = new Point2D.Float(500, 250);
        rgp = new RadialGradientPaint(center, radius, dist, colors, CycleMethod.REFLECT);
        button.setBorder(BorderFactory.createStrokeBorder(stroke, rgp));
        radTabs.addTab("Light Reflect 10", button);

        button = new JButton("Button");
        stroke = new BasicStroke(10);
        center = new Point2D.Float(500, 250);
        rgp = new RadialGradientPaint(center, radius, dist, colors, CycleMethod.REPEAT);
        button.setBorder(BorderFactory.createStrokeBorder(stroke, rgp));
        radTabs.addTab("Light Repeat 10", button);

        mainTabs.addTab("Linear", linTabs);
        mainTabs.addTab("Radial", radTabs);
        add(mainTabs);
        pack();
        setSize(new Dimension(1000, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}