import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;

public class BinaryHandlingApplication {

    /**
     * A data class that encodes to binary output, e.g. to interact with an application in another language.
     * 
     * Binary format: [32 bit int element string size][UTF-8 element string][32 bit element count]
     * The integers are signed, big endian values.
     * The UTF-8 string should not contain a BOM.
     * Note that this class doesn't know anything about files or base 64 encoding.
     */
    public static class DataClass {
        private String element;
        private int elementCount;

        public DataClass(String element) {
            this.element = element;
            this.elementCount = 1;
        }

        public String getElement() {
            return element;
        }

        public void setElementCount(int count) {
            this.elementCount = count;
        }

        public int getElementCount() {
            return elementCount;
        }

        public String toString() {
            return String.format("%s count is %d", element, elementCount);
        }

        public void save(OutputStream out) throws IOException {

            DataOutputStream dataOutputStream = new DataOutputStream(out);

            // so here we have a chain of:
            // a dataoutputstream on a base 64 encoding stream on a fileoutputstream 


            byte[] utf8EncodedString = element.getBytes(UTF_8);
            dataOutputStream.writeInt(utf8EncodedString.length);
            dataOutputStream.write(utf8EncodedString);

            dataOutputStream.writeInt(elementCount);
        }

        public void load(InputStream in) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(in);

            // so here we have a chain of:
            // a datainputstream on a base 64 decoding stream on a fileinputstream 

            int utf8EncodedStringSize = dataInputStream.readInt();
            byte[] utf8EncodedString = new byte[utf8EncodedStringSize];
            dataInputStream.readFully(utf8EncodedString);
            this.element = new String(utf8EncodedString, UTF_8);

            this.elementCount = dataInputStream.readInt();
        }

    }

    /**
     * Create the a base 64 output stream to a file; the file is the text oriented
     * environment.
     */
    private static OutputStream createBase64OutputStreamToFile(String filename) throws FileNotFoundException {
        FileOutputStream textOutputStream = new FileOutputStream(filename);
        return Base64.getUrlEncoder().wrap(textOutputStream);
    }

    /**
     * Create the a base 64 input stream from a file; the file is the text oriented
     * environment.
     */
    private static InputStream createBase64InputStreamFromFile(String filename) throws FileNotFoundException {
        FileInputStream textInputStream = new FileInputStream(filename);
        return Base64.getUrlDecoder().wrap(textInputStream);
    }

    public static void main(String[] args) throws IOException {
        // this text file acts as the text oriented environment for which we need to encode
        String filename = "apples.txt";

        // create the initial class
        DataClass instance = new DataClass("them apples");
        System.out.println(instance);

        // perform some operation on the data
        int newElementCount = instance.getElementCount() + 2;
        instance.setElementCount(newElementCount);

        // write it away
        try (OutputStream out = createBase64OutputStreamToFile(filename)) {
            instance.save(out);
        }

        // read it into another instance, who cares
        DataClass changedInstance = new DataClass("Uh yeah, forgot no-parameter constructor");
        try (InputStream in = createBase64InputStreamFromFile(filename)) {
            changedInstance.load(in);
        }
        System.out.println(changedInstance);
    }
}