import java.io.*;
import SevenZip.Compression.LZMA.*;

public class Create7Zip
{
  public static void main(String[] args) throws Exception
  {

    // file to compress
    File inputToCompress = new File(args[0]);
    BufferedInputStream inputStream  = new BufferedInputStream(new java.io.FileInputStream(inputToCompress));
    // archive
    File compressedOutput = new File(args[1] + ".7z");
    BufferedOutputStream outputStream = new BufferedOutputStream(new java.io.FileOutputStream(compressedOutput));


    Encoder encoder = new Encoder();
    encoder.SetAlgorithm(2);
    encoder.SetDictionarySize(8388608);
    encoder.SetNumFastBytes(128);
    encoder.SetMatchFinder(1);
    encoder.SetLcLpPb(3,0,2);
    encoder.SetEndMarkerMode(false);
    encoder.WriteCoderProperties(outputStream);

    long fileSize;
    fileSize = inputToCompress.length();
    for (int i = 0; i < 8; i++)
    {
      outputStream.write((int) (fileSize >>> (8 * i)) & 0xFF);
    }

    encoder.Code(inputStream, outputStream, -1, -1, null);

    // free resources
    outputStream.flush();
    outputStream.close();
    inputStream.close();
  }
}