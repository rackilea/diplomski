String data = "content://com.android.contacts/data/" + ID;
    // Build the intent
    Intent intent = new Intent();
    intent.setAction(Intent.ACTION_VIEW);
    intent.addCategory(Intent.CATEGORY_DEFAULT);
    // the _ids you save goes here at the end of /data/id
    intent.setData(Uri.parse("content://com.android.contacts/data/" + ID));
    //For audio call
    intent.setComponent(new ComponentName(packageName, "com.google.android.apps.tachyon.ContactsAudioActionActivity"));
    //use this for video call
    //intent.setComponent(new ComponentName(packageName, "com.google.android.apps.tachyon.ContactsVideoActionActivity"));
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    // Verify it resolves
    PackageManager packageManager = context.getPackageManager();
    List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
    boolean isIntentSafe = activities.size() > 0;
    // Start an activity if it's safe
    if (isIntentSafe) {
        context.startActivity(intent);
        Toast.makeText(context, "Opening Duo", Toast.LENGTH_SHORT).show();
    }