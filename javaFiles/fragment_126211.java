import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.LinkedTransferQueue;

public class LinkedTransferQueueReader {
    public static final String fileEnd = "=-=-=-=END=-=-=-=";


    private LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();


    public LinkedTransferQueueReader(File file){
        consume(file);
    }


    public String getLine(){
        String line = "";


        try {
            line = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return line;
    }

    private void consume(File file){
        Thread thread = new Thread(()->{
            final String lineSeparator = System.getProperty("line.separator");
            final char r = lineSeparator.charAt(0);
            char n = '\0';
            if(lineSeparator.length() > 1)
                n = lineSeparator.charAt(1);

            try (RandomAccessFile aFile = new RandomAccessFile(file, "r")){

                FileChannel inChannel = aFile.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(10240);

                StringBuilder line = new StringBuilder();
                while (inChannel.read(buffer) > 0) {
                    buffer.flip();


                    for (int i = 0; i < buffer.limit(); i++) {
                        char as = (char) buffer.get();

                        if(as == n)
                            continue;
                        if(as==r){
                            String compliteLine = line.toString();
                            line = new StringBuilder();


                            queue.transfer(compliteLine);

                        }
                        else {
                            line.append(as);
                        }

                    }

                    buffer.clear();
                }
                inChannel.close();

                queue.transfer(fileEnd);
            }
            catch (Exception ignored){ignored.printStackTrace();}
        });

        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setDaemon(true);
        thread.start();
    }
}