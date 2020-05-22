// Get byte array of image content
    byte[] data = ((DataBufferByte) bufferedImage.getData().getDataBuffer()).getData();

    // Invert bytes because labels/images are inverted
    for (int i = 0; i < data.length; i++)
    {
        data[i] ^= 0xFF;
    }