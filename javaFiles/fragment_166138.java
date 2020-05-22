import java.io.File;
import java.io.RandomAccessFile;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tailer implements Runnable {
    private File file;
    private int runEvery;
    private long lastPosition = 0;
    private boolean run = true;

    public Tailer(String inputFile, int interval) {
        file = new File(inputFile);
        this.runEvery = interval;
    }

    public void stop() {
        run = false;
    }

    public void run() {
        try {
            while(run) {
                Thread.sleep(runEvery);
                long fileLength = file.length();
                if(fileLength > lastPosition) { 
                    RandomAccessFile fh = new RandomAccessFile(file, "r");
                    fh.seek(lastPosition);

                    byte c;
                    while((c = (byte)fh.read()) != -1) {
                        System.out.print((char)c);
                    }
                    lastPosition = fh.getFilePointer();
                    fh.close();
                }
            }
        }
        catch(Exception e) {
            stop();
        }
    }

    public static void main(String argv[]) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Tailer tailer = new Tailer("test.log", 1000);
        executor.execute(tailer);
    } 
}