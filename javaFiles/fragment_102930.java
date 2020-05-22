// Check device for Play Services APK. If check succeeds, proceed with
//  GCM registration.
if (checkPlayServices()) {
   gcm = GoogleCloudMessaging.getInstance(this);
   regid = getRegistrationId(context);

   if (regid.isEmpty()) {
       registerInBackground();
   }
 } else {
   Log.i(TAG, "No valid Google Play Services APK found.");
 }