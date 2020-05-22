import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.GZIPInputStream;

import org.junit.Test;

public class TestGzipCompressingInputStream
{

    @Test
    public void test() throws Exception
    {
        testCompressor("test1 test2 test3");
        testCompressor("1MB binary data",createTestPattern(1024*1024));
        for (int i=0;i<4096;i++)
        {
            testCompressor(i+" bytes of binary data",createTestPattern(i));
        }
    }

    protected byte[] createTestPattern(int size)
    {
        byte[] data=new byte[size];
        byte pattern=0;
        for (int i=0;i<size;i++)
        {
            data[i]=pattern++;
        }
        return data;
    }

    protected void testCompressor(String data) throws IOException
    {
        testCompressor("String: "+data,data.getBytes());
    }
    protected void testCompressor(String dataInfo, byte[] data) throws IOException
    {
        InputStream uncompressedIn=new ByteArrayInputStream(data);
        InputStream compressedIn=new GzipCompressingInputStream(uncompressedIn);
        InputStream uncompressedOut=new GZIPInputStream(compressedIn);

        byte[] result=StreamHelper.readBinaryStream(uncompressedOut);

        assertTrue("Test failed for: "+dataInfo,Arrays.equals(data,result));

    }

}