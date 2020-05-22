public class MoveMe01 {

    public static void main(String[] args) {
        new MoveMe01();
    }

    // How long the animation should run for in milliseconds
    private int runTime = 500;
    // The start time of the animation...
    private long startTime = -1;

    public MoveMe01() {

        EventQueue.invokeLater(new Runnable() {
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

                        if (startTime < 0) {
                            // Start time of the animation...
                            startTime = System.currentTimeMillis();
                        }
                        // The current time
                        long now = System.currentTimeMillis();
                        // The difference in time
                        long dif = now - startTime;
                        // If we've moved beyond the run time, stop the animation
                        if (dif > runTime) {
                            dif = runTime;
                            ((Timer)e.getSource()).stop();
                        }
                        // The percentage of time we've been playing...
                        double progress = (double)dif / (double)runTime;

                        Point location = frame.getLocation();
                        Point to = new Point(location);

                        // Calculate the position as perctange over time...
                        to.x = (int)Math.round(100 * progress);
                        to.y = (int)Math.round(100 * progress);
                        // nb - if the start position wasn't 0x0, then you would need to
                        // add these to the x/y position above...

                        System.out.println(to);

                        frame.setLocation(to);
                    }
                });
                timer.setRepeats(true);
                timer.setCoalesce(true);
                timer.start();

            }
        });
    }
}