ArrayList< BufferedImage > listOfImages = new ArrayList< BufferedImage >();

if (result.next()) {
    Blob blob = result.getBlob("photo");
    listOfImages.add( javax.imageio.ImageIO.read( blob.getBinaryStream() ) ); 
}