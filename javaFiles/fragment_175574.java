// Set up broadcast receiver
private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

    @Override
    public synchronized void onReceive(Context context, Intent intent) {

        if(action.equals(PlayerService.AUDIO_PLAYING)) {

          // Set your play button image to pause here
        }
    }
};