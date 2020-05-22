import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeBoxedWriter extends Writer {
    private static DateFormat FORMAT = new SimpleDateFormat("yyyyDDDHHmm");

    /** Milliseconds to each time box */
    private static final int TIME_BOX = 120000;


    /** For testing only */
    public static void main(String[] args) throws IOException {
        Writer w = new TimeBoxedWriter(new File("."), "test");

        // write one line per second for 500 seconds.
        for(int i = 0;i < 500;i++) {
            w.write("testing " + i + "\n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {}
        }
        w.close();
    }

    /** Output folder */
    private File dir_;

    /** Timestamp for current file */
    private long stamp_ = 0;

    /** Stem for output files */
    private String stem_;

    /** Current output writer */
    private Writer writer_ = null;


    /**
     * Create new output writer
     * 
     * @param dir
     *            the output folder
     * @param stem
     *            the stem used to generate file names
     */
    public TimeBoxedWriter(File dir, String stem) {
        dir_ = dir;
        stem_ = stem;
    }


    @Override
    public void close() throws IOException {
        synchronized (lock) {
            if (writer_ != null) {
                writer_.close();
                writer_ = null;
            }
        }
    }


    @Override
    public void flush() throws IOException {
        synchronized (lock) {
            if (writer_ != null) writer_.flush();
        }
    }


    private void rollover() throws IOException {
        synchronized (lock) {
            long now = System.currentTimeMillis();
            if ((stamp_ + TIME_BOX) < now) {
                if (writer_ != null) {
                    writer_.flush();
                    writer_.close();
                }
                stamp_ = TIME_BOX * (System.currentTimeMillis() / TIME_BOX);
                String time = FORMAT.format(new Date(stamp_));
                writer_ = new FileWriter(new File(dir_, stem_ + "." + time
                        + ".txt"));
            }
        }
    }


    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        synchronized (lock) {
            rollover();
            writer_.write(cbuf, off, len);
        }
    }
}