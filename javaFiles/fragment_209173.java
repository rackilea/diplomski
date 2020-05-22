@Override
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
  if(requestCode == 2000 && resultCode == RESULT_OK){ 
    boolean reset = data.getBooleanExtra("resetVotes", false);
    if(reset){
      yesVoteCount = 0;
      noVoteCount = 0;
    }
   }
}