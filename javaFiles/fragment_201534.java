getContentPane().setLayout(new BorderLayout());
    JPanel panel = new JPanel();
    BoxLayout layout = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
    panel.setLayout(layout);
    JScrollPane scroll
            = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    getContentPane().add(scroll, BorderLayout.CENTER);

    JLabel separator;
    separator = new MySeparator("Sep1");
    panel.add(separator);

    JPanel sub = new MyPanel(new WrapLayout());
    sub.setAlignmentX(0f);
    panel.add(sub);

    sub.add(new MyComponent("A"));
    sub.add(new MyComponent("B"));
    sub.add(new MyComponent("C"));
    sub.add(new MyComponent("D"));
    sub.add(new MyComponent("E"));
    sub.add(new MyComponent("F"));
    sub.add(new MyComponent("G"));
    sub.add(new MyComponent("H"));
    sub.add(new MyComponent("I"));
    sub.add(new MyComponent("J"));
    sub.add(new MyComponent("K"));
    sub.add(new MyComponent("L"));
    sub.add(new MyComponent("M"));
    sub.add(new MyComponent("N"));
    sub.add(new MyComponent("O"));

    separator = new MySeparator("Sep2");
    panel.add(separator);

    // -- Un filler --
    panel.add(Box.createVerticalGlue());


    panel.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {

            WrapLayout wl=(WrapLayout) sub.getLayout();
            Dimension prefdim=wl.preferredLayoutSize(sub);
            sub.setPreferredSize(prefdim);
            // Force the max height = pref height to prevent the BoxLayout dispatching the remaining height between the panel and the glue.
            Dimension maxdim=new Dimension(Short.MAX_VALUE,prefdim.height);
            sub.setMaximumSize(maxdim);
            panel.revalidate();
            panel.repaint();
        }

    });

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(200, 500);
    setLocationRelativeTo(null);
}