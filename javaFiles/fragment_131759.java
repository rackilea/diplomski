int numBytesRead;
    byte[] data = new byte[line.getBufferSize()];

    while (isrecording) {
        numBytesRead = line.read(data, 0, data.length);     
        baos.write(data, 0, numBytesRead);
    }

    try {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(baos.toByteArray());   
        AudioInputStream stream = new AudioInputStream(byteArrayInputStream, format, baos.toByteArray().length);
        AudioSystem.write(stream, AudioFileFormat.Type.WAVE, new File("test.wav"));

        baos.close();
        byteArrayInputStream.close();

    } catch (Exception e) {
        e.printStackTrace();
    }