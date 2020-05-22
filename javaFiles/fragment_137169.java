public class TimerTest01 {

    public static void main(String[] args) {
        new TimerTest01();
    }

    public TimerTest01() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });
    }

    public class TestPane extends JPanel {

        private JLabel label;
        private Timer timer;
        private long startTime;

        public TestPane() {
            setLayout(new GridLayout(0, 1));
            label = new JLabel("...");
            label.setHorizontalAlignment(JLabel.CENTER);
            final JButton btn = new JButton("Start");
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (timer.isRunning()) {
                        timer.stop();
                        btn.setText("Start");
                    } else {
                        startTime = System.currentTimeMillis();
                        timer.restart();
                        btn.setText("Stop");
                    }
                    repaint();
                }
            });
            add(label);
            add(btn);

            timer = new Timer(250, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    long endTime = (startTime + 45000);
                    long timeLeft = endTime - System.currentTimeMillis();
                    if (timeLeft < 0) {
                        timer.stop();
                        label.setText("Expired");
                        btn.setText("Start");
                    } else {
                        label.setText(Long.toString(timeLeft / 1000));
                    }
                    repaint();
                }
            });
        }
    }
}