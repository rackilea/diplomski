import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. run C program
            Process proc = Runtime.getRuntime().exec("./hello");
            InputStream in = proc.getInputStream();
            OutputStream out = proc.getOutputStream();
            // 2. write 'hello' to 'hello' program
            // <change>
            // don't forget to add the new line here or in the 
            // writeToProc method
            writeToProc(out, "hello\n");
            // 3. read response
            readFromProc(in);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // write message to process
    public static void writeToProc(OutputStream out, String msg) throws IOException {
        // <change>
        // Using UTF-8 encoding since all chars in C are byte sized
        byte[] buff = msg.getBytes("UTF-8");
        out.write(buff);
        out.flush();
        System.out.println("done writing: " + new String(buff));
    }

    // read stdin of process
    public static void readFromProc(InputStream in) throws IOException {
        byte[] buff = new byte[256];
        int read = in.read();
        int index = 0;
        while(read != -1) {
            buff[index] = (byte) read;
            read = in.read();
            ++index;
        }
        String str = new String(buff, 0, index);
        System.out.println("proc says: " + str);
    }
}