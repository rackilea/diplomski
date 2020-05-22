sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        isAppInstalled= sharedPreferences.getBoolean("isAppInstalled", false);
        if(isAppInstalled==false){
            Intent intent1 = new Intent(getApplicationContext(),SplashActivity.class);
            intent1.setAction(Intent.ACTION_MAIN);
            Intent intent2 = new Intent();
            intent2.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent1);
            intent2.putExtra(Intent.EXTRA_SHORTCUT_NAME,"My Application");
            intent2.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,Intent.ShortcutIconResource.fromContext(getApplicationContext(),R.drawable.ic_launcher));
            intent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
            getApplicationContext().sendBroadcast(intent2);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isAppInstalled",true);
            editor.commit();

        }