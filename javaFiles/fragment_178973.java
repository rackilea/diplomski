public void init(){
    Log.d(TAG, "init: init() called");
    LineVisualizer lineVisualizer = findViewById(R.id.lineVisualizer);
    // set custom color to the line.
    lineVisualizer.setColor(ContextCompat.getColor(this, R.color.custom));
    // set the line with for the visualizer between 1-10 default 1.
    lineVisualizer.setStrokeWidth(1);
    // Set you media player to the visualizer.
    lineVisualizer.setPlayer(mediaPlayer.getAudioSessionId());  //Added session ID
}