private void timerStart() {
    ActionListener timerAL = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            updateTime();
        }
    };
    // check if swTimer is not null and is currently running
    if (swTimer != null && swTimer.isRunning()) {
        swTimer.stop(); // !! if so STOP it!
    }
    swTimer = new Timer(1000, timerAL);
    swTimer.start();
}