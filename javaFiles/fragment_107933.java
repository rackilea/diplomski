import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class ClassReporter implements Runnable {
    /** Output file */
    File output;

    /** The JVM instrumentation */
    Instrumentation instrument;

    /** Already reported classes */
    Set<Class<?>> known = new HashSet<Class<?>>();

    /** Is reporter still running? */
    volatile boolean running = true;


    @Override
    public void run() {
        System.out.println("Class Reporter agent running");
        while( running ) {
            if (!report()) return;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                return;
            }
        }
    }


    /**
     * Update the report of loaded classes
     * 
     * @return true if report was written OK
     */
    public synchronized boolean report() {
        Set<Class<?>> report = new HashSet<Class<?>>();
        Class<?>[] classes = instrument.getAllLoadedClasses();
        for(Class<?> c:classes) {
            if (known.add(c)) report.add(c);
        }
        if (report.isEmpty()) return true;

        boolean ret = true;
        FileWriter fw = null;
        try {
            fw = new FileWriter(output, true);
            for(Class<?> c:classes) {
                fw.write(c.getName());
                fw.write('\n');

                for(Method m:c.getDeclaredMethods()) {
                    fw.write(m.toGenericString());
                    fw.write('\n');
                }
                fw.write('\n');
                fw.write('\n');
                fw.flush();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            ret = false;
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                    ret = false;
                }
            }
        }
        return ret;
    }


    /**
     * Initialize the reporter
     * 
     * @param agentArgs
     *            the output file name
     * @param inst
     *            the instrumentation
     */
    public static void premain(String agentArgs, Instrumentation inst) {
        final ClassReporter cr = new ClassReporter();
        cr.instrument = inst;
        File out = new File(agentArgs);
        out.delete();
        try {
            out.createNewFile();
        } catch (IOException ioe) {
            System.out.println("Class Reporter could not create file "
                    + out.getAbsolutePath());
            return;
        }
        cr.output = out;

        Thread thread = new Thread(cr);
        thread.setDaemon(true);
        thread.start();

        Thread shutdown = new Thread() {
            public void run() {
                System.out.println("Class Reporter writing final report");
                cr.running = false;
                cr.report();
                System.out.println("Class Reporter done");
            }
        };

        Runtime.getRuntime().addShutdownHook(shutdown);
    }
}