@Override
public IBinder onBind(Intent intent) {
    mBound = true;
    hideNotifications();
    return musicBind;
}

@Override
public void onRebind(Intent intent) {
    mBound = true;
    hideNotifications();
}