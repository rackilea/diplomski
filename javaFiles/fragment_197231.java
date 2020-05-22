else {
    // TODO: 10-10-2018 tapping on notification does nothing!!
    Log.d(TAG, "onHandleIntent(): Sending success notification.");
    String body = "Parsing complete for the url: " + url;
    Intent notifyIntent = new Intent(getApplicationContext(), ListSongsActivity.class);
    notifyIntent.putExtra(Constants.MUSIC_SITE, siteName);
    notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    Bundle bundle = new Bundle();
    bundle.putParcelable(Constants.PARSED_ARTIST_INFO, artistInfo);
    notifyIntent.putExtras(bundle);
    CommonUtils.sendNotification(getApplicationContext(), Constants.LIST_SONGS_NOTIFICATION_TITLE
                            , body, Constants.LIST_SONGS_NOTIFICATION_CHANNEL_ID, notifyIntent,
                            Constants.LIST_SONGS_NOTIFICATION_ID, R.drawable.ic_launcher_background);
   }