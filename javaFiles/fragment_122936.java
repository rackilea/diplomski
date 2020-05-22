// open the sound file as a Java input stream
InputStream in = SoundPlayer.class.getClassLoader().getResourceAsStream("yoursound.wav");

// create an audiostream from the inputstream
AudioStream audioStream = new AudioStream(in);

// play the audio clip with the audioplayer class
AudioPlayer.player.start(audioStream);