public class TestThreadCallBack {

    public static void main(String[] args) {
        new TestThreadCallBack();
    }

    public TestThreadCallBack() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public interface ThreadCallBack {

        public void threadCompleted(Runnable source);

        public void threadFailed(Runnable source);
    }

    public class TestPane extends JPanel implements ThreadCallBack {

        private JLabel message;
        private JLabel dots;
        private int count;

        private Timer timer;

        public TestPane() {
            setLayout(new GridBagLayout());
            message = new JLabel("Running background task, please wait");
            dots = new JLabel("   ");
            add(message);
            add(dots);

            timer = new Timer(250, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    count++;
                    if (count > 3) {
                        count = 0;
                    }
                    StringBuilder sb = new StringBuilder(3);
                    for (int index = 0; index < count; index++) {
                        sb.append(".");
                    }
                    for (int index = count; index < 3; index++) {
                        sb.append(" ");
                    }
                    dots.setText(sb.toString());
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();

            Thread thread = new Thread(new BackgroundTask(this));
            thread.start();

        }

        @Override
        public void threadCompleted(Runnable source) {
            timer.stop();
            message.setText("Task completed successfully");
        }

        @Override
        public void threadFailed(Runnable source) {
            timer.stop();
            message.setText("Task failed");
        }
    }

    public class BackgroundTask implements Runnable {

        private ThreadCallBack callBack;

        public BackgroundTask(ThreadCallBack callBack) {
            this.callBack = callBack;
        }

        @Override
        public void run() {
            System.out.println("Background task underway...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException interruptedException) {
            }
            int result = (int) Math.round((Math.random() * 1));
            if (result == 0) {
                callBack.threadCompleted(this);
            } else {
                callBack.threadFailed(this);
            }
        }
    }
}