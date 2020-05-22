ArrayList<byte> fullImageData = new ArrayList<byte>();
ByteBuffer imgbuf = ByteBuffer.allocate(40395);
int imageBytes = socketChannel.read(imgbuf);

while ((imageBytes = socketChannel.read(imgbuf)) > 0)
{
    imgbuf.flip(); // prepare for reading

    while(imgbuf.hasRemaining())
    {
        fullImageData.add(imgbuf.get());
    }

    imgbuf.clear(); // prepare for next block
}

byte[] byteArray = fullImageData.toArray();
System.out.println(byteArray.length);
InputStream in = new ByteArrayInputStream(byteArray);
BufferedImage img = ImageIO.read(in);