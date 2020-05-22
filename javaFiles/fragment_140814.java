import javax.swing.*;

class SplashTest {

    static boolean useThread = false;

    public static void main(String[] args) {
        // Pass true at the command line to turn on threading.
        // No args, or any value other than true will turn off threading.
        if (args.length > 0) {
            useThread = new Boolean(args[0]);
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SplashFrame splashFrame = new SplashFrame();
                splashFrame.setVisible(true);
                new AppFrame(splashFrame).setVisible(true);
            }});
    }

    private static class BaseFrame extends JFrame {
        public BaseFrame() {
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(200, 200);
            setTitle(getClass().getSimpleName());
        }
    }

    private static class SplashFrame extends BaseFrame implements AppFrameWorkListener {
        JLabel status;

        public SplashFrame() {
            setLocation(0, 0);
            status = new JLabel("Splash Frame");
            getContentPane().add(status);
        }

        public void appFrameWorkStart() {
            status.setText("Work started");
        }

        public void appFrameWorkProgress(long timeElapsed) {
            status.setText("Work has taken " + timeElapsed + "ms so far");
        }

        public void appFrameWorkDone() {
            // http://stackoverflow.com/questions/1234912/how-to-programmatically-close-a-jframe
            setVisible(false);
            dispose();
        }
    }

    private static class AppFrame extends BaseFrame {
        JLabel status;
        AppFrameWorkListener listener;

        public AppFrame(AppFrameWorkListener listener) {
            setLocation(200, 200);
            status = new JLabel("App Frame");
            getContentPane().add(status);

            this.listener = listener;

            // None of this 'heavy lifting' should be in a constructor.
            if (useThread) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        doLotsOfWork(4);
                    }
                }).start();
            } else {
                doLotsOfWork(4);
                onWorkDone();
            }
        }

        private void doLotsOfWork(int workLengthSeconds) {
            // We're starting. Ensure onWorkStart is called on the EDT,
            // as this method may be called from a different Thread.
            invokeOnWorkStartOnEDT();

            long start = System.currentTimeMillis();

            // Hammer the CPU for "workLengthSeconds" number of seconds.
            // And do some contrived progress reporting.
            long workLengthMs = workLengthSeconds * 1000;
            while (System.currentTimeMillis() - start < workLengthMs) {
                long innerStart = System.currentTimeMillis();
                // Consume 250ms CPU before issuing progress update.
                while (System.currentTimeMillis() - innerStart < 250);
                invokeOnWorkProgressOnEDT(System.currentTimeMillis() - start);
            }

            // We're done now. Ensure onWorkDone is called on the EDT,
            // as this method may be called from a different Thread.
            invokeOnWorkDoneOnEDT();
        }

        private void invokeOnWorkStartOnEDT() {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    onWorkStart();
                }
            });
        }

        private void invokeOnWorkProgressOnEDT(final long timeElapsed) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    onWorkProgress(timeElapsed);
                }
            });
        }

        private void invokeOnWorkDoneOnEDT() {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    onWorkDone();
                }
            });
        }

        private void onWorkStart() {
            status.setText("Work Started");
            if (null != listener) {
                // Tell someone who's interested in the work status.
                listener.appFrameWorkStart();
            }
        }

        private void onWorkProgress(long timeElapsed) {
            status.setText("Work has taken " + timeElapsed + "ms so far");
            if (null != listener) {
                // Tell someone who's interested in the work status.
                listener.appFrameWorkProgress(timeElapsed);
            }
        }

        private void onWorkDone() {
            status.setText("Work Done");
            if (null != listener) {
                // Tell someone who's interested in the work status.
                listener.appFrameWorkDone();
            }
        }
    }

    interface AppFrameWorkListener {
        public void appFrameWorkDone();
        public void appFrameWorkStart();
        public void appFrameWorkProgress(long timeElapsed);
    }

}