// Buffered write, time elapsed: 51
// Raw write, time elapsed: 1050

import java.io.*;
import java.util.*;


public class Test {
    public static void main(String [] args) throws Exception {
        int max = 400000;
        List<byte[]> arrays = new ArrayList<>(max);
        for(int i=0; i< max; i++) {
            arrays.add(new byte[40]);
        }

        try(FileOutputStream fout = new FileOutputStream("/tmp/deleteme")) {
            long start = System.currentTimeMillis();
            writeBuffered(arrays, fout);
            System.out.println("Buffered write, time elapsed: " + (System.currentTimeMillis() - start));
        }
        try(FileOutputStream fout = new FileOutputStream("/tmp/deleteme")) {
            long start = System.currentTimeMillis();
            writeRaw(arrays, fout);
            System.out.println("Raw write, time elapsed: " + (System.currentTimeMillis() - start));
        }
    }

    static void writeRaw(List<byte[]> arrays, OutputStream out) throws IOException {
        for (byte[] packet: arrays) {
            out.write(packet);
        }
    }

    static void writeBuffered(List<byte[]> arrays, OutputStream out) throws IOException {
        BufferedOutputStream bout = new BufferedOutputStream(out);
        for (byte[] packet: arrays) {
            bout.write(packet);
        }
    }
}