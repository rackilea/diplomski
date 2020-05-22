public void onClick(View v) {
    if (mp.isPlaying()) {
        mp.pause();
    } else {
        mp.setLooping(true);
        mp.start();
    }
}