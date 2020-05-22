import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class SystemOut {
    public static void main(String[] args) {
        System.out.println("Hi");

        final OutputStream newOs = new OutputStream() {
            FileOutputStream fdOut = new FileOutputStream(FileDescriptor.out);

            @Override
            public void write(int b) throws IOException {
                this.fdOut.write(b);
            }
        };

        System.setOut(new PrintStream(newOs));
        System.out.println("Hi, again");
    }
}