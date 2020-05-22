skypename.setOnClickListener(new OnClickListener() {
           @Override
             public void onClick(View v) {
              if (!isSkypeClientInstalled(MainActivity.this)) {

                goToMarket(MainActivity.this);
                return;
             } else{ 
               Uri skypeUri = Uri.parse("skype:username?chat");
               Intent myIntent = new Intent(Intent.ACTION_VIEW, skypeUri);
               myIntent.setComponent(new ComponentName("com.skype.raider", "com.skype.raider.Main"));
               myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               startActivity(myIntent); 
               }
           }
                });

public void goToMarket(Context myContext) {

    try {
       activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + "com.skype.raider")));
    } catch (android.content.ActivityNotFoundException anfe) {
         activity. startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + "com.skype.raider")));
    }

      return;
     }
public boolean isSkypeClientInstalled(Context myContext) {
      PackageManager myPackageMgr = myContext.getPackageManager();
      try {
       myPackageMgr.getPackageInfo("com.skype.raider", PackageManager.GET_ACTIVITIES);
      }
      catch (PackageManager.NameNotFoundException e) {
       return (false);
      }
      return (true);
     }