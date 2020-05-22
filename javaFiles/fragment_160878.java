Timer timer = new Timer();
timer.scheduleAtFixedRate(new TimerTask() {
    @Override
    public void run() {
        SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                   //Hide the JPanel
                }
            });
        }
    }, 0, 5000);