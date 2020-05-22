import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class TestCompile {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(64);

        try {
            DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            try (StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null)) {
                // >>>> Compiler Stage
                // This sets up the class path that the compiler will use.
                // I've added the .jar file that contains the DoStuff interface within in it...
                List<String> optionList = new ArrayList<>();
                optionList.add("-classpath");
                optionList.add(System.getProperty("java.class.path"));

                Iterable<? extends JavaFileObject> compilationUnit
                                = fileManager.getJavaFileObjectsFromFiles(Arrays.asList(new File("src/HelloWorld.java")));
                JavaCompiler.CompilationTask task = compiler.getTask(
                                null,
                                fileManager,
                                diagnostics,
                                optionList,
                                null,
                                compilationUnit);
                if (task.call()) {
                    // <<<< Compiler Stage
                    // >>>> Run stage...
                    ProcessBuilder pb = new ProcessBuilder("java", "-cp", "./src", "HelloWorld");
                    pb.redirectError();
                    Process p = pb.start();

                    InputStreamConsumer.consume(p.getInputStream());

                    p.waitFor();
                    // <<<< Run Stage
                } else {
                    for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
                        System.out.format("Error on line %d in %s%n",
                                        diagnostic.getLineNumber(),
                                        diagnostic.getSource().toUri());
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(TestCompile.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

    public static class InputStreamConsumer implements Runnable {

        private InputStream is;

        public InputStreamConsumer(InputStream is) {
            this.is = is;
        }

        public InputStream getInputStream() {
            return is;
        }

        public static void consume(InputStream is) {
            InputStreamConsumer consumer = new InputStreamConsumer(is);
            Thread t = new Thread(consumer);
            t.start();
        }

        @Override
        public void run() {
            InputStream is = getInputStream();
            int in = -1;
            try {
                while ((in = is.read()) != -1) {
                    System.out.print((char)in);
                }
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }

    }
}