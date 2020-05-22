// Gets an input stream for the given file
AudioInputStream ais = AudioSystem.getAudioInputStream(file);

// Gets a clip that can be used for playing an audio file or stream
Clip clip = AudioSystem.getClip();

// Opens the AudioInputStream in the clip
clip.open(ais);