public static void main(String[] args) throws IOException, TagException
{
    File sourceFile = new File("/Users/JohnSmith/Desktop/MusicTester/1234.mp3");
    final MP3File mp3file = new MP3File(sourceFile);
    final ID3v1 tag = mp3file.getID3v1Tag();
    if (null == tag)
    {
        System.out.println("No ID3 tag found!");
    }
    else
    {
        System.out.println(tag.getAlbum());
        System.out.println(tag.getAlbumTitle());
        System.out.println(tag.getTitle()); 
        System.out.println(tag.getComment());   
    }
}