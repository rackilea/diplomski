public class Watcher implements ActionListener {
    private int length;
    private int ticks = 0;
    public Watcher(int time) {
        length = time;
    }

    public void actionPerformed(ActionEvent evt) {
        tick++;
        int timeRemaining = length - (tick * 1000);
        if (timeRemaining <= 0) {
            // Game over
        } else {
            labelShowingTimeRemaining.setText(Integer.toString((int)Math.round(timeRemaining / 1000)));
        }
    }
}