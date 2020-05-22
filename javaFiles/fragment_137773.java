import java.io.*;

public class Main {

    public static int countLines(String filename) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(filename));


        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            int lastLine = 0;
            int lastNumber = 0;

            boolean empty = true;
            while (  (readChars = is.read(c))  != -1) {

                for (int i = 0; i < readChars; ++i){
                    Byte b  = c[i];
                    lastLine = b.intValue() - 48;

                    if (empty) {
                        lastNumber = 0;
                    }

                    if (c[i] == '\n'){
                        ++count;
                        empty = true;

                    } else {
                        lastNumber *= 10;
                        lastNumber += lastLine;
                        empty  = false;
                    }
                }   // END inner- FOR-LOOP

            }// END WHILE-LOOP
            if (!empty) {
                count++;
            }


            int asciiVal  = lastLine;
            int lastLine2 = Character.getNumericValue(asciiVal);
            System.out.println("the last line was "  + lastNumber);

            return count;


        } finally {
            is.close();
        }

    }//END method countLines

    public static void main(String[] args) throws IOException {
        System.out.print(countLines("/tmp/test.txt"));
    }
}