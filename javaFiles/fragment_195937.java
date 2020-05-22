class GUI extends JFrame {

    public static void main(String[] args) {

        new GUI();
    }

    public GUI() {

        JTabbedPane tabs = new JTabbedPane();
        JButton button;
        Border b1, b2, b3, b4, b5, b6;

        button = new JButton("Button");
        button.setBorder(compoundBorder(interpolateColors(Color.BLACK, Color.GREEN, 5)));
        tabs.addTab("Black-Green 5", button);

        button = new JButton("Button");
        button.setBorder(compoundBorder(interpolateColors(Color.BLACK, Color.GREEN, 100)));
        tabs.addTab("Black-Green 100", button);

        button = new JButton("Button");
        button.setBorder(compoundBorder(interpolateColors(Color.BLACK, Color.GREEN, 200)));
        tabs.addTab("Black-Green 200", button);

        button = new JButton("Button");
        button.setBorder(compoundBorder(interpolateColors(Color.GREEN, Color.BLACK, 5)));
        tabs.addTab("Green-Black 5", button);

        button = new JButton("Button");
        button.setBorder(compoundBorder(interpolateColors(Color.GREEN, Color.BLACK, 100)));
        tabs.addTab("Green-Black 100", button);

        button = new JButton("Button");
        button.setBorder(compoundBorder(interpolateColors(Color.GREEN, Color.BLACK, 200)));
        tabs.addTab("Green-Black 200", button);

        button = new JButton("Button");
        b1 = compoundBorder(interpolateColors(Color.GREEN, Color.BLACK, 5));
        b2 = compoundBorder(interpolateColors(Color.BLACK, Color.GRAY, 5));
        button.setBorder(BorderFactory.createCompoundBorder(b2, b1));
        tabs.add("Green-Black-Gray 5", button);

        button = new JButton("Button");
        b1 = compoundBorder(interpolateColors(Color.GREEN, Color.BLACK, 50));
        b2 = compoundBorder(interpolateColors(Color.BLACK, Color.GRAY, 50));
        button.setBorder(BorderFactory.createCompoundBorder(b2, b1));
        tabs.add("Green-Black-Gray 50", button);

        button = new JButton("Button");
        b1 = compoundBorder(interpolateColors(Color.GREEN, Color.BLACK, 100));
        b2 = compoundBorder(interpolateColors(Color.BLACK, Color.GRAY, 100));
        button.setBorder(BorderFactory.createCompoundBorder(b2, b1));
        tabs.add("Green-Black-Gray 100", button);

        button = new JButton("Button");
        b1 = compoundBorder(interpolateColors(Color.GREEN, Color.BLUE, 50));
        b2 = compoundBorder(interpolateColors(Color.BLUE, Color.RED, 50));
        b3 = compoundBorder(interpolateColors(Color.RED, Color.GREEN, 50));
        button.setBorder(compoundBorder(new Border[] {b1, b2, b3}));
        tabs.add("Green-Blue-Red-Green 50", button);

        button = new JButton("Button");
        b1 = compoundBorder(interpolateColors(Color.GREEN, Color.BLUE, 50));
        b2 = compoundBorder(interpolateColors(Color.BLUE, Color.RED, 50));
        b3 = compoundBorder(interpolateColors(Color.RED, Color.GREEN, 50));
        button.setBorder(compoundBorder(new Border[] {b3, b2, b1}));
        tabs.add("{Green, Blue, Red} 50", button);

        button = new JButton("Button");
        b1 = compoundBorder(interpolateColors(Color.MAGENTA, Color.BLUE, 2));
        b2 = compoundBorder(interpolateColors(Color.BLUE, Color.CYAN, 2));
        b3 = compoundBorder(interpolateColors(Color.CYAN, Color.GREEN, 2));
        b4 = compoundBorder(interpolateColors(Color.GREEN, Color.YELLOW, 2));
        b5 = compoundBorder(interpolateColors(Color.YELLOW, Color.ORANGE, 2));
        b6 = compoundBorder(interpolateColors(Color.ORANGE, Color.RED, 2));
        button.setBorder(compoundBorder(new Border[] {b1, b2, b3, b4, b5, b6}));
        tabs.add("Rainbow 2", button);

        button = new JButton("Button");
        b1 = compoundBorder(interpolateColors(Color.MAGENTA, Color.BLUE, 20));
        b2 = compoundBorder(interpolateColors(Color.BLUE, Color.CYAN, 20));
        b3 = compoundBorder(interpolateColors(Color.CYAN, Color.GREEN, 20));
        b4 = compoundBorder(interpolateColors(Color.GREEN, Color.YELLOW, 20));
        b5 = compoundBorder(interpolateColors(Color.YELLOW, Color.ORANGE, 20));
        b6 = compoundBorder(interpolateColors(Color.ORANGE, Color.RED, 20));
        button.setBorder(compoundBorder(new Border[] {b1, b2, b3, b4, b5, b6}));
        tabs.add("Rainbow 20", button);

        button = new JButton("Button");
        b1 = compoundBorder(interpolateColors(Color.MAGENTA, Color.BLUE, 40));
        b2 = compoundBorder(interpolateColors(Color.BLUE, Color.CYAN, 30));
        b3 = compoundBorder(interpolateColors(Color.CYAN, Color.GREEN, 15));
        b4 = compoundBorder(interpolateColors(Color.GREEN, Color.YELLOW, 15));
        b5 = compoundBorder(interpolateColors(Color.YELLOW, Color.ORANGE, 30));
        b6 = compoundBorder(interpolateColors(Color.ORANGE, Color.RED, 40));
        button.setBorder(compoundBorder(new Border[] {b1, b2, b3, b4, b5, b6}));
        tabs.add("Rainbow assymetric", button);

        add(tabs);
        pack();
        setSize(new Dimension(1000, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private static Color[] interpolateColors(Color c1, Color c2, int width) {

        Color[] colors = new Color[width];
        for (int i = 0; i < width; i++) {
            colors[i] = new Color( (c2.getRed() - c1.getRed()) / width * i + c1.getRed(),
                                  (c2.getGreen() - c1.getGreen()) / width * i + c1.getGreen(),
                                  (c2.getBlue() - c1.getBlue()) / width * i + c1.getBlue() );
        }
        return colors;
    }

    private static Border compoundBorder(Color[] colors) {

        Border b = BorderFactory.createLineBorder(colors[0], 1, true);
        for (int i = 1; i < colors.length; i++)
            b = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(colors[i], 1, true), b);
        return b;
    }

    private static Border compoundBorder(Border[] borders) {

        Border b = borders[0];
        for (int i = 1; i < borders.length; i++)
            b = BorderFactory.createCompoundBorder(borders[i], b);
        return b;
    }
}