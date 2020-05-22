public void onProgressChanged(SeekBar seekBar, int progress,
        boolean fromUser) {
    if(progress>95){
        seekBar.setVisibility(SeekBar.INVISIBLE);
                    //code

    }

public void onStopTrackingTouch(SeekBar seekBar) {
    seekBar.setProgress(0);

}