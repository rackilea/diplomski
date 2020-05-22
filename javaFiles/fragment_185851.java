private static InputStream getAudioStream(String filename) throws Exception {
    File file = new File(filename);
    AudioInputStream in = AudioSystem.getAudioInputStream(file);
    AudioFormat baseFormat = in.getFormat();
    AudioFormat decodedFormat = new AudioFormat(
        AudioFormat.Encoding.PCM_UNSIGNED,
        baseFormat.getSampleRate(),
        baseFormat.getSampleSizeInBits(),
        baseFormat.getChannels(),
        baseFormat.getChannels(),
        baseFormat.getSampleRate(),
        false);
    return AudioSystem.getAudioInputStream(decodedFormat, in);
}