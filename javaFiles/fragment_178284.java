import java.nio.file.Files;
import java.nio.file.Paths;
public class Main {
    public static void main(String args[]) throws Exception{
        String str = "255[...]0A2525454F46"; //0x removed, omitted data
        byte[] arr = hexStringToByteArray(str);    
        Files.write(Paths.get("test.pdf"), arr);
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}