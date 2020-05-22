package test;

import java.io.*;
import java.nio.*;


public class Test {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        DataOutput stream = new DataOutputStream(new FileOutputStream(new File("C:/Users/Brandon/Desktop/test_file.dat")));

        int sizeofint = 4;
        int sizeoflong = 4;

        ByteBuffer buffer = ByteBuffer.allocate(sizeofint + sizeofint + sizeoflong).order(ByteOrder.LITTLE_ENDIAN);
        buffer.putInt(5).putInt(6).putInt(7);

        byte[] bytes = buffer.array();

        for (byte b : bytes) {
            stream.write(b); 
        }
    }

}