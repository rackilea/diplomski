private Timer updateTimer;

// ...

EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {

        updateTimer = new Timer(250, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Update compulations here...
            }
        });
        updateTimer.setRepeats(false);
        updateTimer.setCoalesce(true);

        Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {

            @Override
            public void eventDispatched(AWTEvent event) {
                updateTimer.restart();
            }
        }, AWTEvent.PAINT_EVENT_MASK);
    }
}