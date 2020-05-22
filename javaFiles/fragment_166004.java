public void pauseAudio(View... views) { //Allow a dynamic initialization of an array of Views
    for(View view : views) { //Loop through the array
        if(view != null && view.isEnabled()) { //If the current view is not null and enabled
            if(mediaPlayer!=null && mediaPlayer.isPlaying()){ //If the MediaPlayer is not null and playing
                mediaPlayer.stop(); //Stop the MediaPlayer
            }
            break; //Break the loop, as we have reached our usecase
        }
    }
}