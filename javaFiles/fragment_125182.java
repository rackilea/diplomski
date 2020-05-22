public html(Context externalContext)  {
        Intent i2 = new Intent("android.intent.action.MAIN");
        i2.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
        i2.addCategory("android.intent.category.LAUNCHER");
        i2.setData(Uri.parse("https://wwww.google.com"));
        i2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        System.out.println("hello1");
        externalContext.startActivity(i2); --> START WITH EXTERNAL CONTEXT!!!
        System.out.println("hello2");