public class TimeKeeper extends JPanel {

    private Timer timer;
    private int delay = 1000; // every 1 second
    private int counter = 0;
    private int[] times = {};
    private String[] commands = {};

    public TimeKeeper() {
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println(counter);
                counter = counter + 1;

                if (counter == times[0]) {
                    //new SayText();
                    //SayText.say(commands[0]);
                }
                if (counter == times[1]) {
                    //SayText.say(commands[1]);
                } else {
                    timer.stop();
                }
            }
        };

        timer = new Timer(delay, action);
        timer.setInitialDelay(0);
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

}