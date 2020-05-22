import java.io.*;
import java.lang.management.ManagementFactory;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

public class NioIoLock {

    public static void main(String[] args)
            throws IOException, InterruptedException {
        String workDir = System.getProperty("user.dir");

        FileChannel channelIo, channelNio;
        FileLock lockIo, lockNio;

        // use io
        {
            String fileName = workDir + File.separator
                + ManagementFactory.getRuntimeMXBean().getName() + ".io";
            File lockFile = new File(fileName);
            lockFile.deleteOnExit();
            RandomAccessFile file = new RandomAccessFile(lockFile, "rw");
            channelIo = file.getChannel();
        }

        // use nio
        {
            Path workDirPath = Paths.get(workDir);
            Path file = workDirPath.resolve(Paths
                .get(ManagementFactory.getRuntimeMXBean().getName() + ".nio"));

            // open/create test file
            channelNio = FileChannel.open(file, StandardOpenOption.READ,
                StandardOpenOption.WRITE, StandardOpenOption.CREATE,
                StandardOpenOption.DELETE_ON_CLOSE
                /*, com.sun.nio.file.ExtendedOpenOption.NOSHARE_DELETE*/);
        }

        // do not release locks for some time
        Thread.sleep(10000);
    }
}