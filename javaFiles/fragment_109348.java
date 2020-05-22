LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

// You need to declare an Intent for your class and declare a PendingIntent on it,
// so it might be passed to the addProximityAlert method as the fifth parameter.
Intent intent = new Intent("com.yourdomain.yourproject.MyAlert");
PendingIntent proxIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

lm.addProximityAlert(your_latitude, your_longitude, RADIUS_IN_METERS, -1, proxIntent);