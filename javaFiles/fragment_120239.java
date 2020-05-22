byte[] bytes = new byte[1024]; //your input
byte[] result = bytes;
if( bytes[0] != 0xFF || bytes[1] != 0xD8 )
{    
    BufferedImage image = ImageIO.read( new ByteArrayInputStream( bytes ) );
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write( image, "jpeg", baos );
    result = baos.toByteArray();
}