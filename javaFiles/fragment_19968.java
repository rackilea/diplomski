public void onFinish() {
    playNotification(this);
    azanCountdownH1.setText("Get ready now");
}


public static void playNotification(Context context){
    MediaPlayer mp = MediaPlayer.create(context, R.raw.azan);
    mp.start();
}