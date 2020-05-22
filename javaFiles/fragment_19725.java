CustomSeekBar(Context context, CharSequence label){
    myContext = context;
    myLabel = label;

    TextView myValue = new TextView(myContext);
    SeekBar mySeekBar = new SeekBar(myContext);
    myValue.setText(myLabel);
    mySeekBar.setProgress(3);

}