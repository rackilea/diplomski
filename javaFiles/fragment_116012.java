public AudioInputStream append(AudioInputStream main, AudioInputStream s)
            throws UnsupportedAudioFileException, IOException {

        SequenceInputStream sis = new SequenceInputStream(main, s);

        long length = main.getFrameLength() + s.getFrameLength();
        logger.debug(main.getFrameLength() + "+" + s.getFrameLength() + 
                    "=" + length);

        AudioFormat fmt = main.getFormat();

        File file = new File("c:/MyNew.wav"); //changed for testing

        AudioInputStream ais = new AudioInputStream(sis, fmt, length);
        int size = AudioSystem.write( ais, AudioFileFormat.Type.WAVE, file);
        logger.debug("Wrote :" + size);

        return AudioSystem.getAudioInputStream(file);
    }