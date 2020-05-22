import java.util.*;
import java.lang.*;
import java.io.*;

class Conversion
{
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        String hexadecimal3 = "f1f2f3f4";
        byte[] ebcdic = hexStringToByteArray(hexadecimal3);
        System.out.println(  new String(ebcdic, "Cp273") ); // prints 1234
    }
}