@Override
public void onProgressChanged(SeekBar seekBar, int progress,
        boolean fromUser) {
    tvc.setText(String.valueOf(progress-100));
    TextView tvp = (TextView) findViewById(R.id.textView14);
    tvp.setText(tvc.getText().toString());
}