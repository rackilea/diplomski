public class MoveMe01 {

    public static void main(String[] args) {
        new MoveMe01();
    }

    public MoveMe01() {

        EventQueue.invokeLater(
                new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                final JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JLabel("Use the Force Luke"));
                frame.pack();
                frame.setLocation(0, 0);
                frame.setVisible(true);

                Timer timer = new Timer(40, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Point location = frame.getLocation();
                        Point to = new Point(location);
                        if (to.x < 100) {
                            to.x += 4;
                            if (to.x > 100) {
                                to.x = 100;
                            }
                        }
                        if (to.y < 100) {
                            to.y += 4;
                            if (to.y > 100) {
                                to.y = 100;
                            }
                        }

                        frame.setLocation(to);

                        if (to.equals(location)) {
                            ((Timer)e.getSource()).stop();
                        }
                    }
                });
                timer.setRepeats(true);
                timer.setCoalesce(true);
                timer.start();

            }
        });
    }
}