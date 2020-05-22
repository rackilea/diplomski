import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class TestMain {

    public static void main(String[] args) {
        List<File> sourceList = Arrays.asList(Paths.get("MyJavaClass.java").toFile());
        List<String> errorList = new TestMain().compile(sourceList);
        if(errorList.size() == 0) {
            System.out.println("No error found, perfectly valid java class");
        } else {
            errorList.forEach(System.out::println);
        }
    }

    public List<String> compile (List<File> javaFileList) {
        System.out.println("Started compilation");
        List<String> errorList = new ArrayList<String>();
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(
                diagnostics, null, null);

        Iterable<? extends JavaFileObject> compilationUnits = fileManager
                .getJavaFileObjectsFromFiles(javaFileList);
        compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits)
                .call();

        for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics
                .getDiagnostics()) {
            String diagnosticMessage = String.format("Error on line %d in %s%n",
                    diagnostic.getLineNumber(), diagnostic.getSource().toUri() + " : \n\t" + diagnostic.getMessage(null));

            /*Following gives out of box good message, but I used above to show the custom use of diagnostic
             * String diagnosticMessage = diagnostic.toString();*/

            errorList.add(diagnosticMessage);
        }
        try {
            fileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return errorList;
    }
}