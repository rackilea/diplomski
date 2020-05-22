public class YOURCLASS {

private int seekBarValue;

...(other code)...

slidingBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        seekBarValue = progress;
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        TextView resultText = (TextView) findViewById(R.id.resultText);
        resultText.setText(seekBarValue + "");
        resultText.setTextSize(seekBarValue);
    }
});

secondActivityButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
        startIntent.putExtra("com.example.willh.seekbar.something", seekBarValue);
        startActivity(startIntent);
    }
});
}