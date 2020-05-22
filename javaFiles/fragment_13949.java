File soundFile = new File(this.inputFilePath);
AudioInputStream mp3InputStream = AudioSystem.getAudioInputStream(soundFile);
AudioFormat baseFormat = mp3InputStream.getFormat();
AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,  baseFormat.getSampleRate(),  16, baseFormat.getChannels(), baseFormat.getChannels() * 2,  baseFormat.getSampleRate(), false);

AudioInputStream convertedAudioInputStream =  AudioSystem.getAudioInputStream(decodedFormat, mp3InputStream);

File outputFile = new File(this.outputFilePath);
AudioSystem.write(convertedAudioInputStream, AudioFileFormat.Type.WAVE, outputFile);