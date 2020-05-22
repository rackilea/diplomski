private void showDialog() {
    View.OnClickListener dialogHandler = 
      new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // process "PROCEED" button
      }
    };  

    commonModule.myDialog customDialog = comMod.new myDialog();
    customDialog.inputBox(this, "Submit Results", 
      "Your results will be submitted.", dialogHandler);
  }