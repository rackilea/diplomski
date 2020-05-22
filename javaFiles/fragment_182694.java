aSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        float value = ((float)progress / 10.0);
        // value now holds the decimal value between 0.0 and 10.0 of the progress
        // Example:
        // If the progress changed to 45, value would now hold 4.5
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}
});