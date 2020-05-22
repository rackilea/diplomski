for (int i = -1; i < 10; i++) {
    System.out.println("AudioSystem stream " + i);
    mDTMFPlayer = new ToneGenerator(i, TONE_RELATIVE_VOLUME);
    long startTime = System.currentTimeMillis();
    mDTMFPlayer.startTone(ToneGenerator.TONE_DTMF_0);
    Log.d(TAG, "After 1st: " + (System.currentTimeMillis() - startTime));
    try {Thread.sleep(160);} catch (InterruptedException e) {}
    mDTMFPlayer.stopTone();

    startTime = System.currentTimeMillis();
    mDTMFPlayer.startTone(ToneGenerator.TONE_DTMF_0);
    Log.d(TAG, "After 2nd: " + (System.currentTimeMillis() - startTime));
    try {Thread.sleep(160);} catch (InterruptedException e) {}
    mDTMFPlayer.stopTone();

    startTime = System.currentTimeMillis();
    mDTMFPlayer.startTone(ToneGenerator.TONE_DTMF_0);
    Log.d(TAG, "After 3rd: " + (System.currentTimeMillis() - startTime));
    try {Thread.sleep(160);} catch (InterruptedException e) {}
    mDTMFPlayer.stopTone();
    mDTMFPlayer.release();
}