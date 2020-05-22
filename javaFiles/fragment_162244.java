seekbar.setOnSeekBarChangeListener( new OnSeekBarChangeListener()
{
   public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser)
  {
    spinnervalue=(EditText)findViewById(R.id.editText1);        
    spinnervalue.setText("$"+""+(progress*1000));
  }
});