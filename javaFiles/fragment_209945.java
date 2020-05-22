seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {         
    int seeked_progess;

    @Override
    public void onProgressChanged(final SeekBar seekBar, int progress, boolean fromUser) {

        seeked_progess = progress;
        seeked_progess = seeked_progess * 1000;

        if (fromUser) {                 
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
});