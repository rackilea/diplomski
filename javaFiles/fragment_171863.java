public class Player {
private static final String TAG = Player.class.getName();
private AudioTrack audioTrack;
private boolean isWorking;

public Player() {
    try {
        audioTrack = new AudioTrack(
                new AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                        .setLegacyStreamType(AudioManager.STREAM_MUSIC)
                        .build(),

                new AudioFormat.Builder()
                        .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                        .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                        .setSampleRate(AudioConsts.SAMPLERATE)
                        .build(),

                AudioConsts.GetPlayerBufferSize(),
                AudioTrack.MODE_STREAM,
                AudioManager.AUDIO_SESSION_ID_GENERATE);

    } catch (Exception e) {
        Log.e(TAG, e.toString());
    }
}

public void play() {
    audioTrack.play();
}

public void stopReading() {
    if (!isWorking)
        return;

    audioTrack.release();
    isWorking = false;
}

public void appendForPlayback(byte[] audioMessage, int size) {
    new Executor().doInBackground(audioMessage);
}

private class Executor extends AsyncTask<byte[], Void, Void> {
    @Override
    protected Void doInBackground(byte[]... bytes) {
        for (byte[] audioMessage : bytes) {
            if (audioMessage.length != 0) {
                int writen = audioTrack.write(audioMessage, 0, audioMessage.length);
                if (writen != audioMessage.length) {
                    Log.d(TAG, "WTF");
                }
            }

        }

        return null;
    }
}}