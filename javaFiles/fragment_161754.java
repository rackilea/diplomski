private void playTone(final int freq, final double duration)
{
    Thread thread = new Thread(new Runnable()
    {
        public void run()
        {
            genTone(freq, duration);
        }
    });

    thread.start();
}


private void playSamples(byte[] generatedSound, int sampleRate, int numSamples)
{
    AudioTrack audioTrack = null;
    try
    {
        audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, sampleRate, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT,
                (int) numSamples * 2, AudioTrack.MODE_STATIC);

        // Load the track
        audioTrack.write(generatedSound, 0, generatedSound.length);
        audioTrack.play();
    }
    catch (Exception e)
    {
        Log.e(MainActivity.DEBUG_TAG, "Audio track exception: " + e.getMessage());
    }

    int x = 0;
    do
    { // Montior playback to find when done
        if (audioTrack != null)
            x = audioTrack.getPlaybackHeadPosition();
        else
            x = numSamples;
    }
    while (x < numSamples);
    audioTrack.release();
}