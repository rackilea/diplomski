File soundFile = new File(this.audioFilePath);
AudioInputStream originalAudioInputStream = AudioSystem.getAudioInputStream(soundFile);
AudioFormat audioFormat = originalAudioInputStream.getFormat();

float startInBytes = (startTimeinMs / 1000 * audioFormat.getSampleRate() * audioFormat.getFrameSize());
float lengthInFrames = ((endTimeinMs - startTimeinMs) / 1000 * audioFormat.getSampleRate());

originalAudioInputStream.skip((long) startInBytes);
AudioInputStream partAudioInputStream = new AudioInputStream(originalAudioInputStream,
                originalAudioInputStream.getFormat(), (long) lengthInFrames);

// code to actually play the audio input stream here