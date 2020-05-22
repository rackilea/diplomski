SharedPreferences prefs = getSharedPreferences(Activity.class.getSimpleName(), Context.MODE_PRIVATE);
int notificationNumber = prefs.getInt("notificationNumber", 0);


notificationManager.notify(notificationNumber, notification);
SharedPreferences.Editor editor = prefs.edit();
notificationNumber++;
editor.putInt("notificationNumber", notificationNumber);
editor.commit();