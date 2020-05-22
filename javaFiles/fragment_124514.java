public class ShapeGame {
    Timer timer;
    int counter = 10;

    // note change to constructor parameter
    public ShapeGame(final JLabel label) {
        ActionListener a = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Counter = " + counter);

                // note changes
                // labTimer.setText("Timer: " + counter);
                label.setText("Timer: " + counter);

                if (--counter < 0) {
                    timer.stop();
                    System.exit(0);
                }
            }
        };

        timer = new Timer(1000, a);
        timer.start();
    }
}