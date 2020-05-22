Mp3File song = new Mp3File(filename);
if (song.hasId3v2Tag()){
     ID3v2 id3v2tag = song.getId3v2Tag();
     byte[] imageData = id3v2tag.getAlbumImage();
     //converting the bytes to an image
     BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageData));
}