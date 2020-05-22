public class LoadFile {
    public static void main(String[] args)  throws Exception  {
        InputStream stream = 
            LoadFile.class.getResourceAsStream("/songwavs/s1_..._.wav");
            AudioSystem.getAudioFileFormat(stream);
            AudioSystem.getAudioFileFormat(url);
    }
}