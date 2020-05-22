import javazoom.spi.vorbis.sampled.file.VorbisAudioFileReader;
import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;
import org.tritonus.share.sampled.file.TAudioFileReader;
import org.tritonus.sampled.file.AuAudioFileReader;

  AudioInputStream createOggMp3(File fileIn) throws IOException, Exception {
    AudioInputStream audioInputStream=null;
    AudioFormat targetFormat=null;
    try {
      AudioInputStream in=null;
      if(fileIn.getName().endsWith(".ogg")) {
        VorbisAudioFileReader vb=new VorbisAudioFileReader();
        in=vb.getAudioInputStream(fileIn);
      }
      else if(fileIn.getName().endsWith(".mp3")) {
        MpegAudioFileReader mp=new MpegAudioFileReader();
        in=mp.getAudioInputStream(fileIn);
      }
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
    catch(UnsupportedAudioFileException ue) { System.out.println("\nUnsupported Audio"); }
    return audioInputStream;
  }