private void updateImageButtonsSequentially() {
    int iteration = 0;
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
              int resourceId = this.getResources().getIdentifier("c"+iteration+"_r"+right_num, "id", this.getPackageName());
              iteration++;
              ImageButton imageButton = (ImageButton) findViewById(resourceId);
              imageButton.setBackgroundResource(R.drawable.white_circle);
        }
    },0,500);
}