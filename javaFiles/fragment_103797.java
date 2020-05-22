File sample1 = new File("f1.wav");
File sample2 = new File("f2.wav");

File fileOut = new File("combined.wav");

AudioInputStream audio1 = AudioSystem.getAudioInputStream(sample1);
AudioInputStream audio2 = AudioSystem.getAudioInputStream(sample2);

AudioInputStream audioBuild = new AudioInputStream(new SequenceInputStream(audio1, audio2), audio1.getFormat(), audio1.getFrameLength() + audio2.getFrameLength());

for(int i = 0; i < 5; i++)
{
    audioBuild = new AudioInputStream(new SequenceInputStream(audioBuild, /* keep creating new input streams */ AudioSystem.getAudioInputStream(sample2)), audioBuild.getFormat(), audioBuild.getFrameLength() + audio2.getFrameLength());
}

AudioSystem.write(audioBuild, AudioFileFormat.Type.WAVE, fileOut);