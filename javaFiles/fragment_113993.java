import java.io.*;
import java.nio.charset.*;

public class SOPipe
{
    public static void main(String[] args) throws Exception
    {
        PipedOutputStream os = new PipedOutputStream();
        PipedInputStream is = new PipedInputStream(os);

        ReaderThread readerThread = new ReaderThread(is);
        WriterThread writerThread = new WriterThread(os);

        readerThread.start();
        writerThread.start();

        readerThread.join();
        writerThread.join();

        System.out.println("Both Reader and Writer completed.");
        System.out.println("Main method returning normally now.");
    }

    private static final Charset LATIN1 = Charset.forName("latin1");

    public static class WriterThread extends Thread
    {
        private final PipedOutputStream _os;

        public WriterThread(PipedOutputStream os)
        {
            _os = os;
        }

        public void run()
        {
            try
            {
                String msg = "Ceci n'est pas une pipe";
                byte[] msgBytes = msg.getBytes(LATIN1);
                System.out.println("WriterThread sending message: " + msg);
                for(int i = 0; i < msgBytes.length; i++)
                {
                    _os.write(msgBytes, i, 1);
                    System.out.println("WriterThread wrote a byte!");
                    _os.flush();
                }
                _os.close();
                System.out.println("[COMPLETED] WriterThread");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public static class ReaderThread extends Thread
    {
        private final PipedInputStream _is;

        public ReaderThread(PipedInputStream is)
        {
            _is = is;
        }

        public void run()
        {
            try
            {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1];
                int read;
                while ((read = _is.read(buffer, 0, 1)) != -1)
                {
                    System.out.println("ReaderThread read a byte!");
                    baos.write(buffer, 0, read);
                }
                System.out.println("[COMPLETED] ReaderThread; received: " 
                        + new String(baos.toByteArray(), LATIN1));
                _is.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}