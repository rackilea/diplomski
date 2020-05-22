private Long startTime;
private Handler handler = new Handler();  
startTime = System.currentTimeMillis();

handler.removeCallbacks(updateTimer);
handler.postDelayed(updateTimer, 1000);

private Runnable updateTimer = new Runnable() {
    public void run() {
        final TextView time = (TextView) findViewById(R.id.timer);
        Long spentTime = System.currentTimeMillis() - startTime;
        //計算目前已過分鐘數
        Long minius = (spentTime/1000)/60;
        //計算目前已過秒數
        Long seconds = (spentTime/1000) % 60;
        time.setText(minius+":"+seconds);
        handler.postDelayed(this, 1000);
    }
};