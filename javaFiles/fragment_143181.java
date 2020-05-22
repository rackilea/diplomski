addKeyListener(new KeyAdapter() {
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (isTimerRunning()){
                stopTimer();
            } else {
                startTimer();
            }
        }
    }
});