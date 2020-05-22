boolean changedProgrammatically;

     mInterestRateEditText.addTextChangedListener(new TextWatcher() {
      public void afterTextChanged(Editable s) {
        int i = Integer.parseInt(s.toString());
    if(!changedProgrammatically){
        if (i >= 0 && i <= 100) {
          mInterestRateSeekBar.setProgress(50); 
        }

    }else{
changedProgrammatically = false;
}
      }
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

      public void onTextChanged(CharSequence s, int start, int before, int count) {}
    });

    mInterestRateSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
    changedProgrammatically = true;
        mInterestRateEditText.setText(progress + "");
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

      }
    });