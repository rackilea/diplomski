@Override
protected void onStart() {
    super.onStart();
    count = 2400;
    final Timer t = new Timer();//Create the object
    t.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            minLeft = (int) Math.floor(count / 60);
            secLeft = count - minLeft * 60;
            counter = minLeft + ":" + secLeft;
            // the name of your actual activity
            MyActivity.this.runOnUiThread(new Runnable() {
               @Override
               public void run() {
                 TextView tv = (TextView) findViewById(R.id.timer);
                 Log.i(MainActivity.TAG,minLeft+", "+secLeft+", "+counter);
                 tv.setText(counter);
               }
            });

            count--;
            if (minLeft <= 0 && secLeft <= 0) {
                t.cancel();
                count = 2400;
                onFinish();
            }
        }
    }, 1000, 1000);
}