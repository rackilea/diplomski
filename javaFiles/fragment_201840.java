mHandler.post(new Runnable() {
    @Override
    public void run() {
        if (pressTime == 0)
            displayTime.setText("You missed your ring");
    }
});