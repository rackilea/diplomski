btnShowResut.setOnClickListener(new View.OnClickListener() {
   @Override
   // Create intent for going to another activity
   Intent intent = new Intent(this, AnotherActivity.class);
   // Put counts datas to intent
   intent.putExtra("yesCountKey", yesVoteCount);
   intent.putExtra("noCountKey", noVoteCount);


   // NEW : Go to another activity by calling it instead
   // REQUEST_CODE is an integer variable
   startActivityForResult(intent, REQUEST_CODE);

   }
});