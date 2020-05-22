public static void main(String[] args) {
        final JFrame frame = new JFrame("Gears AWT");

        final JPanel intro = new JPanel();
        Action action = new AbstractAction("Start Gears") {

            @Override
            public void actionPerformed(ActionEvent e) {
                GearsApplet gears = new GearsApplet();
                gears.init();
                frame.remove(intro);
                frame.add(gears);
                frame.getRootPane().revalidate();
            }
        };
        JButton button = new JButton(action);
        intro.add(button);
        frame.add(intro); //.display_parent);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }