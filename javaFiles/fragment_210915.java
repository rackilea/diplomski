package dk.tbsalling.stackoverflow;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.zip.*;

import org.apache.commons.codec.binary.Base64;

public class App
{
    private byte[] compress(String stringToCompress) throws UnsupportedEncodingException
    {
        byte[] compressedData = new byte[1024];
        byte[] stringAsBytes = stringToCompress.getBytes("UTF-8");

        Deflater compressor = new Deflater();
        compressor.setInput(stringAsBytes);
        compressor.finish();
        int compressedDataLength = compressor.deflate(compressedData);

        return Arrays.copyOf(compressedData, compressedDataLength);
    }

    private String decompressToString(byte[] compressedData) throws UnsupportedEncodingException, DataFormatException
    {   
        Inflater deCompressor = new Inflater();
        deCompressor.setInput(compressedData, 0, compressedData.length);
        byte[] output = new byte[1024];
        int decompressedDataLength = deCompressor.inflate(output);
        deCompressor.end();

        return new String(output, 0, decompressedDataLength, "UTF-8");
    }

    public static void main(String[] args) throws UnsupportedEncodingException, DataFormatException {
        App m = new App();
        String strToBeCompressed  = "jhjksdhgfkjdsfhkjhjvblkajnlkdfmvlksjfdovbjaiudhv adjv ajgvoig avigogauguivadfhijbjkla";
        byte[] compressedData  = m.compress(strToBeCompressed);
        String deCompressedString = m.decompressToString(compressedData);

        System.out.println("Original     :: " + strToBeCompressed.length() + " " + strToBeCompressed);
        System.out.println("Compressed   :: " + compressedData.toString());
        System.out.println("decompressed :: " + deCompressedString.length() + " " + deCompressedString);
    }
}