int mProgress =10000;
seekbar.setOnSeekBarChangeListener( new OnSeekBarChangeListener()
{
   public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser)
  {

    mProgress = progress*1000+10000;
    spinnervalue=(EditText)findViewById(R.id.editText1);        
    spinnervalue.setText("$"+""+mProgress);
  }
});