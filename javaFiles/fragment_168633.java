String identifier = null;
 TelephonyManager tm =   (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
 if (tm != null)
  identifier = tm.getDeviceId();
 if (identifier == null || identifier .length() == 0)
  identifier = Secure.getString(activity.getContentResolver(),Secure.ANDROID_ID);