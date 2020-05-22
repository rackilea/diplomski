import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class HelloWorld{
     public static void main(String []args){
        String str = "c";
        CRC32 crc = new CRC32();
        crc.update(str.getBytes());
        String enc = String.format("%08X", crc.getValue());
        System.out.println(enc);
     }
}