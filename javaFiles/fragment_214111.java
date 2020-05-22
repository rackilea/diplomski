int delay = 1000;
new Timer(delay, new ActionListener() {
    private int count = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (count < 10) {
            lblDisplay.setText("Completed " + counter);
        } else {
            ((Timer) e.getSource()).stop(); // stop the Timer
        }
        counter++;
    }
}).start();