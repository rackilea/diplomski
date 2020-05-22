final AudioInputStream in = new AudioInputStream(
        new FileInputStream(tempFile),
        format,
        tempFile.length()/format.getFrameSize()
);
AudioSystem.write(in, AudioFileFormat.Type.WAVE, file);
in.close();