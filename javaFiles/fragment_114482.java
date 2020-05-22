public AudioInputStream readMP3URL(String f) {
AudioInputStream audioInputStream=null;
AudioFormat targetFormat=null;
try {
  AudioInputStream in=null;
    MpegAudioFileReader mp=new MpegAudioFileReader();
    in=mp.getAudioInputStream(new URL(f));
  AudioFormat baseFormat=in.getFormat();
targetFormat=new AudioFormat(
          AudioFormat.Encoding.PCM_SIGNED,
          baseFormat.getSampleRate(),
          16,
          baseFormat.getChannels(),
          baseFormat.getChannels() * 2,
          baseFormat.getSampleRate(),
          false);
      audioInputStream=AudioSystem.getAudioInputStream(targetFormat, in);
}
catch(Exception ue) { System.out.println("\nUnsupported Audio"); }
return audioInputStream;
}

public void readURL() {
  int i, j, k=0, l, basicU=1024;
  AudioFormat targetFormat=null;
audioInputStream=readMP3URL("http://c5.rbxcdn.com/2e6d33a5b3b1d8f250c395816ff9f145");
  if(audioInputStream==null) System.out.println("null audiostream");
targetFormat=audioInputStream.getFormat();
byte[] data=new byte[basicU];
DataLine.Info dinfo=new DataLine.Info(SourceDataLine.class, targetFormat);
SourceDataLine line=null;
  try {
    line=(SourceDataLine)AudioSystem.getLine(dinfo);
  if(line!=null) {
    line.open(targetFormat);
    line.start();
      while((k=audioInputStream.read(data, 0, data.length))!=-1) {
      line.write(data, 0, k);
    }
    line.stop();
    line.close();
  }
}
catch(Exception ex) { ex.printStackTrace(); System.out.println("audio problem "+ex); }
}