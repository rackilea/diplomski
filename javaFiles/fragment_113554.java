final int TIME_TO_COUNT = 5000; //ms
//Update interval in ms. Consider that the screen cannot be updated as often as you want.
//17ms (about 60FPS) sound reasonable
final int UPDATE_INTERVAL = 17;
final int number = 5001; //Can be any number between 0 and Integer.MAX_VALUE;

new Thread(new Runnable() {
    public void run() {
        double counter = 0.0;
        while (counter < number) {
            try {
                Thread.sleep(UPDATE_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            textView.post(new Runnable() {
                public void run() {
                    textView.setText(String.valueOf(Math.ceil(counter)));
                }
            });
            counter += (number / (double) TIME_TO_COUNT) * UPDATE_INTERVAL;
        }
    }
}).start();