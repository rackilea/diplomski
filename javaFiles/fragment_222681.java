@Override
public void onClick(View view) {
    try {
        if (mp.isPlaying()) {
            mp.stop();
            mp.release();
        }
        rndm = r.nextInt(High - Low) + Low;
        mp = MediaPlayer.create(getApplicationContext(), sounds[rndm]);
        mp.start();
    } catch (Exception e) {
        e.printStackTrace();
    }
}