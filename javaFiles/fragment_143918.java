import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import static java.nio.file.StandardOpenOption.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // Open the file as a FileChannel.
        Set<OpenOption> options = new HashSet<>();
        options.add(WRITE);
        // options.add(SYNC);     <------- This would force O_SYNC semantics.
        try (FileChannel channel = FileChannel.open(Paths.get("./test.txt"), options)) {

            // Generate a bit data to write.
            ByteBuffer buffer = ByteBuffer.allocate(4096);
            for (int i = 0; i < 10; i++) {
                buffer.put(i, (byte) i);
            }

            // Choose a random offset between 0 and 1023 and write to it.
            long offset = ThreadLocalRandom.current().nextLong(0, 1024);
            channel.write(buffer, offset);
        }
    }
}