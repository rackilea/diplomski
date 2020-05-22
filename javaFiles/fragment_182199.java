import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public interface FileWriter {
    FileWriter append(CharSequence seq);

    FileWriter indent(int indent);

    void close();
}

class AsyncFileWriter implements FileWriter, Runnable {
    private final File file;
    private final Writer out;
    private final BlockingQueue<Item> queue = new LinkedBlockingQueue<Item>();
    private volatile boolean started = false;
    private volatile boolean stopped = false;

    public AsyncFileWriter(File file) throws IOException {
        this.file = file;
        this.out = new BufferedWriter(new java.io.FileWriter(file));
    }

    public FileWriter append(CharSequence seq) {
        if (!started) {
            throw new IllegalStateException("open() call expected before append()");
        }
        try {
            queue.put(new CharSeqItem(seq));
        } catch (InterruptedException ignored) {
        }
        return this;
    }

    public FileWriter indent(int indent) {
        if (!started) {
            throw new IllegalStateException("open() call expected before append()");
        }
        try {
            queue.put(new IndentItem(indent));
        } catch (InterruptedException ignored) {
        }
        return this;
    }

    public void open() {
        this.started = true;
        new Thread(this).start();
    }

    public void run() {
        while (!stopped) {
            try {
                Item item = queue.poll(100, TimeUnit.MICROSECONDS);
                if (item != null) {
                    try {
                        item.write(out);
                    } catch (IOException logme) {
                    }
                }
            } catch (InterruptedException e) {
            }
        }
        try {
            out.close();
        } catch (IOException ignore) {
        }
    }

    public void close() {
        this.stopped = true;
    }

    private static interface Item {
        void write(Writer out) throws IOException;
    }

    private static class CharSeqItem implements Item {
        private final CharSequence sequence;

        public CharSeqItem(CharSequence sequence) {
            this.sequence = sequence;
        }

        public void write(Writer out) throws IOException {
            out.append(sequence);
        }
    }

    private static class IndentItem implements Item {
        private final int indent;

        public IndentItem(int indent) {
            this.indent = indent;
        }

        public void write(Writer out) throws IOException {
            for (int i = 0; i < indent; i++) {
                out.append(" ");
            }
        }
    }
}