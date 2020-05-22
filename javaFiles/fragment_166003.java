public void pauseAudio(View... views) {
    for(View view : views) {
        if(view.isEnabled()) {
            if(mediaPlayer!=null && mediaPlayer.isPlaying()){
                mediaPlayer.stop();
            }
            break;
        }
    }
}