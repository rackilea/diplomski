public class T extends JFrame {

private int couterValue = 3;
private JPanel welcome;
private JLabel counter;

private JPanel other;
private Timer timer;

public T() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    buildWelcomePanel();
    buildOtherPanel();

    add(welcome);
    setSize(550, 450);
    setLocationRelativeTo(null);
    setVisible(true);

    timer = new Timer();
    timer.schedule(new TimerTask() {

        @Override
        public void run() {
            if (couterValue == 0) {
                timer.cancel();
                // Switch the panels as the counter reached 0
                remove(welcome);
                add(other);
                validate();
            } else {
                counter.setText(couterValue + ""); // Update the UI counter
                couterValue--;
            }
        }
    }, 0, 1000);

}

private void buildWelcomePanel() {
    welcome = new JPanel();
    counter = new JLabel();
    welcome.add(counter);
}

private void buildOtherPanel() {
    other = new JPanel();
    JLabel otherStuff = new JLabel("Anything else ...");
    other.add(otherStuff);
}

public static void main(String[] args) {
    new T();
}
}