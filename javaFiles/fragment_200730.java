/* Called when the go100 button is clicked, it slides the seekBar from its current position
    to 100 in an adjusted time given the previous progress of the seekbar,
    given maximum 4 seconds and minimum 0 seconds
     */
    public void go100(View view){
        final SeekBar seekBar =  (SeekBar) findViewById(R.id.seekBar);
        ObjectAnimator anim = ObjectAnimator.ofInt(seekBar, "progress", seekBar.getProgress(),100);
        anim.setDuration(4000-(4000*seekBar.getProgress()/100));
        anim.start();
    }

    /* Called when the go0 button is clicked, it slides the seekBar from its current position
    to 100 in an adjusted time given the previous progress of the seekbar,
    given maximum 4 seconds and minimum 0 seconds
    */
    public void go0 (View view){
        final SeekBar seekBar =  (SeekBar) findViewById(R.id.seekBar);
        ObjectAnimator anim2 = ObjectAnimator.ofInt(seekBar, "progress", seekBar.getProgress(),0);
        anim2.setDuration(4000*seekBar.getProgress()/100);
        anim2.start();
    }