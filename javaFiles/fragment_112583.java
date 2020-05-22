SharedPreferences sharedPrefs = getSharedPreferences("com.mypck.asd", MODE_PRIVATE);
boolean buttonState = sharedPrefs.getBoolean("NameOfThingToSave", true);

if(buttonState)
{
  mFab.setDrawable(getResources().getDrawable(R.drawable.ic_play)); 
}else{
  mFab.setDrawable(getResources().getDrawable(R.drawable.ic_pause));
}