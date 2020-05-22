@Override
public void onProgressChanged(SeekBar seekBar, int progress,
        boolean fromUser) {
    String progress = String.valueOf(progress-100)
    tvc.setText(progress);
    tvp.setText(progress); // move the findViewById outside this method, and put it with tvc
}