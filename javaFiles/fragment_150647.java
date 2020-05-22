import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class ReadFile {

    public static void main(String args[]) {

        try
        {   
            String s; 
            Integer I;
            String file_name="C:/Users/User/test.txt";
            RandomAccessFile input_file = new RandomAccessFile(file_name,"r");
            FileInputStream in = new FileInputStream(file_name);
            FileChannel ch = in.getChannel();
            FileChannel inChannel = input_file.getChannel();
            long file_size = inChannel.size();
            ByteBuffer buffer = ByteBuffer.allocate((int) file_size);

            Charset cs = Charset.forName("ASCII");
            ArrayList<Character> character = new ArrayList<Character>();
            // inChannel.read(buffer);

            int rd;
            while ( (rd = ch.read( buffer )) != -1 ) 
            {
                buffer.rewind();

                CharBuffer chbuf = cs.decode(buffer);

                System.out.println("ASCII values read: ");

                System.out.println();

                     for ( int i = 0; i < chbuf.length(); i++ ) 
                    {

                        int j = chbuf.get();

                        character.add((char)j);

                        System.out.println("j("+i+"): "+j+" ");

                    }

                     System.out.println();

                     System.out.println("Chars they represent: ");

                     System.out.println();

                     for ( int i = 0; i < character.size(); i++ ) 
                        {

                        System.out.println("character("+i+"): "+character.get(i)+" ");
                        System.out.println();
                        s = character.get(i).toString();
                        if(!(s.equals(" ")||s.equals("\r")))
                            {
                            System.out.println("s("+i+"): "+s+" ");
                            System.out.println();
                            System.out.println("s("+i+").length(): "+s.length()+" ");
                            System.out.println();
                            I = new Integer(s);
                            System.out.println("I("+i+"): "+I+" ");
                            System.out.println();
                            }
                        }

                buffer.clear();
                inChannel.close();
                input_file.close();
            }
        }
        catch (IOException exc){}
    }
}