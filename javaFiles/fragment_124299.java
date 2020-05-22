// Specify the output format you want
        AudioFormat target = new AudioFormat(16000f, 16, 1, true, false);
        // Get the audio stream ready, and pass in the raw byte[]
        AudioInputStream is = AudioSystem.getAudioInputStream(target, new AudioInputStream(new ByteArrayInputStream(raw), AudioReceiveHandler.OUTPUT_FORMAT, raw.length));
        // Write a temporary file to the computer somewhere, this method will return a InputStream that can be used for recognition
        try {
            AudioSystem.write(is, AudioFileFormat.Type.WAVE, new File("C:\\filename.wav"));
        } catch(Exception e) {}