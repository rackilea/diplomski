//Write This Code Inside onCreate Methode
Timer timer = new Timer();
MyTimer myTimer = new MyTimer();
timer.schedule(myTimer, 1000, 1000);

//Make this Class Outside onCreate Methode
 class MyTimer extends TimerTask {
    @Override
    public void run() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < btn.size; i++) {
                    buttons[i].setBackgroundColor(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));
                }
            }
        });
    }
}