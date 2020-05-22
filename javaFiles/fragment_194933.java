final int samples = 44100;
boolean isMono = true;
final short[] data = new short[samples * 5];

final AudioRecorder recorder = Gdx.audio.newAudioRecorder(samples, isMono);
final AudioDevice player = Gdx.audio.newAudioDevice(samples, isMono);

new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("Record: Start");
        recorder.read(data, 0, data.length);
        recorder.dispose();
        System.out.println("Record: End");
        System.out.println("Play : Start");
        player.writeSamples(data, 0, data.length);
        System.out.println("Play : End");
        player.dispose();
    }
}).start();