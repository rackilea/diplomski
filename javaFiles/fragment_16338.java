public class DoubleActionTimer {

    private final Action action1;
    private final Action action2;

    private final int delay1;
    private final int delay2;

    private final Timer timer;

    private DoubleActionTimer(Action action1, int delay1, Action action2, int delay2) {
        this.timer = new Timer(delay1, new ActionSwitcher());

        this.action1 = action1;
        this.delay1 = delay1;
        this.action2 = action2;
        this.delay2 = delay2;

        this.timer.setRepeats(false);
        this.timer.start();
    }

    public void stop() {
        this.timer.stop();
    }

    private class ActionSwitcher extends AbstractAction {

        private boolean flag = false;

        /**
         * Invoked when an action occurs.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            final Action action = flag?action2:action1;
            final int delay = flag?delay1:delay2;
            flag = !flag;

            action.actionPerformed(e);
            timer.setInitialDelay(delay);
            timer.start();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        final Action action1 = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Action1"+new Date());
            }
        };
        final Action action2 = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Action2 "+new Date());
            }
        };

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DoubleActionTimer(action1, 500, action2, 3000);
            }
        });

        TimeUnit.SECONDS.sleep(60);
    }
}