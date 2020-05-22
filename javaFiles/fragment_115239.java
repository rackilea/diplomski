public void stop() {
    if (mp==null)
        return;
    if (mp.isPlaying()){
        mp.stop();
        mp.reset();
        mp.release();
    }
}