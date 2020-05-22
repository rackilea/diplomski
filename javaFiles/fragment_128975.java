private final ActionListener timerTask = new ActionListener() {
    @Override
    public void actionPerformed(final ActionEvent e) {
        // Whatever you need to to that
        showNextImage();
    }
};

Timer timer = new Timer(1000, timerTask);
timer.start();