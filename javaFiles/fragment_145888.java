public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException, IOException {
    File file = ...;
    File output = ...;

    AudioInputStream ais;
    AudioInputStream eightKhzInputStream = null;
    ais = AudioSystem.getAudioInputStream(file);
    AudioFormat sourceFormat = ais.getFormat();
    if (ais.getFormat().getSampleRate() == 22050f) {
        AudioFileFormat sourceFileFormat = AudioSystem.getAudioFileFormat(file);
        AudioFileFormat.Type targetFileType = sourceFileFormat.getType();

        AudioFormat targetFormat = new AudioFormat(
                sourceFormat.getEncoding(),
                8000f,
                sourceFormat.getSampleSizeInBits(),
                sourceFormat.getChannels(),
                sourceFormat.getFrameSize(),
                8000f,
                sourceFormat.isBigEndian());
        if (!AudioSystem.isFileTypeSupported(targetFileType) || ! AudioSystem.isConversionSupported(targetFormat, sourceFormat)) {
              throw new IllegalStateException("Conversion not supported!");
        }
        eightKhzInputStream = AudioSystem.getAudioInputStream(targetFormat, ais);
        int nWrittenBytes = 0;

        nWrittenBytes = AudioSystem.write(eightKhzInputStream, targetFileType, output);
        System.out.println("nWrittenBytes: " + nWrittenBytes);
    }
}