if (scoreCurrent == 0) {
        countDownTimer.cancel();
        countDownTimer = null;
        // Use Timer to set visibility to GONE after the animation finishes.            
                    TimerTask timerTask = new TimerTask(){
                        @Override
                        public void run() {
                            PressActivity.this.runOnUiThread(new Runnable(){
                                public void run() {
                                    resumeLogicAfterPress();
                                }
                            });}};
                    Timer timer = new Timer();
                    timer.schedule(timerTask, getWhammyAnimationTotalDuration(actAnim));
    } else {
        resumeLogicAfterPress();
    }

}

public void resumeLogicAfterPress() {
    // Display the whammy that was added
            for (int i = 0; i < whammy; i++) {
                popup[i].setVisibility(View.VISIBLE);

            }


            sleep(2500); //Adds a delay so that the whammy pop up can be seen

            //Start the background music
            playmp3(mpPress, R.raw.press);
            // if whammy = 4. stop all and move to high score
            if (whammy == 4) {
                stop();
                stopmp3();
                callFinish();
            }
            // if spint >0 start new data random
            if (spint > 0) {
                stop();
                final Button bstop = (Button) findViewById(R.id.btstop);
                bstop.setEnabled(true);
                start(10000 * 60 * 60 * 24);
            } else {
                // stop all
                stop();
                stopmp3();
                // if spin < 2, that round <2 move to spin activity
                if (spin < 2) {
                    Intent it = new Intent(getBaseContext(), SpinActivity.class);
                    startActivity(it);
                    finish();
                }
                // esle move to high score activity
                else {
                    callFinish();
                }
            }
}

private void whammy() {
    // set up the whammy act animation
    final ImageView act = (ImageView) findViewById(R.id.whammyact);
    act.setBackgroundResource(R.drawable.tnt_animation);
    actAnim = (AnimationDrawable) act.getBackground();
    actAnim.setVisible(true, true); 
    }