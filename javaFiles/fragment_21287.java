SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
boolean isFirstLaunch = prefs.getBoolean("first_launch", true);
if (isFirstLaunch) {
    // Do your stuff here...
    sendSMS();

    // Remember that you already have sent the SMS
    prefs.edit().putBoolean("first_launch", false).apply();
}