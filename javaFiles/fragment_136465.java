/**
 * @param inputFilenameWithPath : binary filepath
 * @param outputFilepath        : output image path
 * @param start                 : from where the image start in binary file
 * @param len                   : length of the image
 * @throws ImageAccessException
 */
public void extractImageFromBinaryFile(String inputFilenameWithPath, String outputFilepath, int start, int len) throws ImageAccessException
{
    try
    {
        File file = new File(inputFilenameWithPath);
        FileImageInputStream iis = new FileImageInputStream(file);

        // Added
        byte[] b = new byte[start];
        iis.read(b, 0, start);

        byte[] fb = new byte[]{};
        iis.read(fb);

        IIOByteBuffer iiob = new IIOByteBuffer(fb, start, len);
        iis.readBytes(iiob, len);

        OutputStream os = new FileOutputStream(outputFilepath);
        os.write(iiob.getData());
        iis.close();
        os.close();

    }
    catch (IOException ioe)
    {`enter code here`
        throw new ImageAccessException("Image File read/write error");
    }
}