File fileWithUnsignedFormat;

AudioInputStream sourceInputStream;
AudioInputStream targetInputStream;

AudioFormat sourceFormat;
AudioFormat targetFormat;

SourceDataLine sourceDataLine;

sourceInputStream = AudioSystem.getAudioInputStream(fileWithUnsignedFormat);
sourceFormat = sourceInputStream.getFormat();

targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 
    sourceFormat.getSampleRate(), 
    sourceFormat.getSampleSizeInBits(), 
    sourceFormat.getChannels(), 
    sourceFormat.getFrameSize(), 
    sourceFormat.getFrameRate(), 
    false);

targetInputStream = AudioSystem.getAudioInputStream(targetFormat, sourceInputStream);

DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, targetFormat);
sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);

sourceDataLine.open(targetFormat);
sourceLine.start();


// schematic
targetInputStream.read(byteArray, 0, byteArray.length);
sourceDataLine.write(byteArray, 0, byteArray.length);