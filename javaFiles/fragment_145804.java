SharedPreferences settings = getSharedPreferences(Example.PREFS_NAME, 0);
//Get "hasLoggedIn" value. If the value doesn't exist yet false is returned
boolean hasLoggedIn = settings.getBoolean("hasLoggedIn", false);

if(hasLoggedIn)
{
    //Go directly to main activity.
}
else
{
  // Show Login Activity
}