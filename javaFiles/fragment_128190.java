tone = new TimerTask() {
    @Override
    public void run() {
        if (sound[0] % 4 != 0) {
            s2.start();
            sound[0] += 1;
            runOnUiThread(new Runnable() {
             @Override
                 public void run() {
                    square.setBackgroundColor(Color.parseColor("#ff0000"));
                }
            });