timer = new Timer(TIMER_DELAY, e -> {
    if (currentIndexLabel != paint.length-1) {
        upateLabels();
        timer.restart(); //Do this check again after 1000ms
    }
});
button.addActionListener(e -> timer.start());