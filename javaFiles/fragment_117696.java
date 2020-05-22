File myFile = new File("test.au");
byte[] samples;

AudioInputStream is = AudioSystem.getAudioInputStream(myFile);
DataInputStream dis = new DataInputStream(is);      //So we can use readFully()
try
{
    AudioFormat format = is.getFormat();
    samples = new byte[(int)(is.getFrameLength() * format.getFrameSize())];
    dis.readFully(samples);
}
finally
{
    dis.close();
}