final Intent intent=new Intent();
intent.setAction("com.pkg.App1");
intent.putExtra("KeyName","code1id");
intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
intent.setComponent(  
    new ComponentName("com.pkg.App2","com.pkg.App2.MyBroadcastReceiver"));  
sendBroadcast(intent);