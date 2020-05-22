public class TestMigFlow2 extends JFrame {

    public TestMigFlow2() {

        getContentPane().setLayout(new BorderLayout());
        JPanel panel = new JPanel(new MigLayout("fillx, flowy", "[fill]"));
        JScrollPane scroll
                = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        getContentPane().add(scroll, BorderLayout.CENTER);

        panel.add(new MySeparator("sep1"), "growy 0, shrinky 100");

        JPanel sub = new JPanel(new WrapLayout());
        panel.add(sub, "shrinky 100"); // Works well on grow but not on shrink

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

        panel.add(new MySeparator("sep2"), "growy 0, shrinky 100");

        panel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {

                WrapLayout wl = (WrapLayout) sub.getLayout();
                Dimension prefdim = wl.preferredLayoutSize(sub);
                sub.setPreferredSize(prefdim);
                panel.revalidate();
                panel.repaint();
            }

        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200, 500);
        setLocationRelativeTo(null);
    }