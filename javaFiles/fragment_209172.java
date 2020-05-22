...
onCreate(...){
  ...
  // Retrieve datas from intent
  int yesCount = getIntent().getIntExtra("yesCountKey", 0);
  int noCount = getIntent().getIntExtra("noCountKey", 0);

  mResetButton.setOnClickListener(new View.OnClickListener() {
   @Override

     // Send a boolean to main activity for clearing votes
     Intent intent = new Intent();
     intent.putExtra("resetVotes", true);
     setResult(RESULT_OK, intent);
     // Close second activity
     finish();
   }
});

}