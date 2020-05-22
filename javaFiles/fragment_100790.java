public class Counter extends JFrame {

    private static final String stop = "Stop";
    private static final String start = "Start";
    private final ClockListener clock = new ClockListener();
    private final Timer timer = new Timer(53, clock);
    private final JTextField tf = new JTextField(9);
    private final SimpleDateFormat date = new SimpleDateFormat("mm.ss.SSS");
    private long startTime;

    public Counter() {
        timer.setInitialDelay(0);

        JPanel panel = new JPanel();
        tf.setHorizontalAlignment(JTextField.RIGHT);
        tf.setEditable(false);
        panel.add(tf);
        final JToggleButton b = new JToggleButton(start);
        b.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (b.isSelected()) {
                    startTime = System.currentTimeMillis();
                    timer.start();
                    b.setText(stop);
                } 
                else {
                    updateClock();
                    startTime = 0;

                    timer.stop();
                    b.setText(start);
                }
            }
        });
        panel.add(b);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setTitle("Timer");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    private void updateClock() {
        Date elapsed = new Date(System.currentTimeMillis() - startTime);
        tf.setText(date.format(elapsed));
    }
    private class ClockListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateClock();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Counter clock = new Counter();
            }
        });
    }
}