@Overrride
    public void onBackPressed(View v) {
     // save data first

      Intent MainActivityIntent = new Intent(CurrentActivityName.this, MainActivityClass); 
      startActivity(MainActivityIntent);
      super.onBackPressed();
}