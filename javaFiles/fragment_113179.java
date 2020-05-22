@Override
   public void onBackPressed()
   {
        startActivity(new Intent(this, HomeActivity.class).
        setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | IntentCompat.FLAG_ACTIVITY_CLEAR_TASK).putExtra(EXIT_FLAG, true));
   }