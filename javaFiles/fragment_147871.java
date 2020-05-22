PackageManager pm = getPackageManager();

//apps package names

String instagram = "com.instagram.android",
       youtube = "com.google.android.youtube",
       facebook = "com.facebook.katana",
       whatsapp = "com.whatsapp";
       //other apps package names
       // can be found in url of app in play store in the browser
       //ex: https://play.google.com/store/apps/details?id=***com.whatsapp***&hl=en

//launch the app

Intent appIntent = pm.getLaunchIntentForPackage(instagram);//change app package name
if(appIntent != null)
  startActivity(appIntent);
else {
//App not installed !
}