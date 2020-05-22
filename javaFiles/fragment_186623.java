public int onStartCommand(Intent intent, int flags, int startId) {
  // ...

  if (intent.getAction().equals(STOP_MY_SERVICE)) {
    stopSelf();
    return START_STICKY;
  }

  if (intent.getAction().equals(START_FOREGROUND)) {

    // startForeground(...);

    return START_STICKY;
  }

  if (intent.getAction().equals(STOP_FOREGROUND)) {
    stopForeground(true);
    return START_STICKY;
  }

  // ...
  return START_STICKY;
}