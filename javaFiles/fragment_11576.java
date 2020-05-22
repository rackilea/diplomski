import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.Callable;

import org.apache.commons.io.IOUtils;

public class GeniaTagger {

    /**
     * @param args
     */
    public static void main(String[] args) {
        tagFile(new File("inputText.txt"), new File("outputText.txt"));
    }

    public static void tagFile(File input, File output) {
        FileInputStream ifs = null;
        FileOutputStream ofs = null;
        try {
            ifs = new FileInputStream(input);
            ofs = new FileOutputStream(output);
            final FileInputStream ifsRef = ifs;
            final FileOutputStream ofsRef = ofs;

            // {1}    
            ProcessBuilder pb = new ProcessBuilder("geniatagger.exe");
            final Process pr = pb.start();

            // {2}
            runInThread(new Callable<Void>() {
                public Void call() throws Exception {
                    IOUtils.copy(ifsRef, pr.getOutputStream());
                    IOUtils.closeQuietly(pr.getOutputStream());   // {3}
                    return null;
                }
            });
            runInThread(new Callable<Void>() {
                public Void call() throws Exception {
                    IOUtils.copy(pr.getInputStream(), ofsRef);   // {4}
                    return null;
                }
            });
            runInThread(new Callable<Void>() {
                public Void call() throws Exception {
                    IOUtils.copy(pr.getErrorStream(), System.err);
                    return null;
                }
            });

            // {5}
            pr.waitFor();
            // output file is written at this point.
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // {6}
            IOUtils.closeQuietly(ifs);
            IOUtils.closeQuietly(ofs);
        }
    }

    public static void runInThread(final Callable<?> c) {
        new Thread() {
            public void run() {
                try {
                    c.call();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                }
            }
        }.start();
    }
}