package nz.test.loader;

public interface Executer {

    public void execute();

}


package nz.test.loader;

import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class LoadClass {

    public static void main(String[] argv) throws Exception {

        URL[] urls = null;

        File dir = new File(System.getProperty("user.dir") + File.separator + "out/dir" + File.separator);
        File classFile = new File(dir,"nz/co.test/loader/MyClass.class");
        long lastModified = classFile.lastModified();
        URL url = dir.toURI().toURL();
        urls = new URL[] { url };
        ClassLoader cl = new URLClassLoader(urls);
        compileClass("first class", dir.getAbsolutePath());

        Class cls = cl.loadClass("nz.test.loader.MyClass");
        Executer myObj = (Executer) cls.newInstance();

        myObj.execute();
        compileClass("another class", dir.getAbsolutePath());
        cl = new URLClassLoader(urls);

        cls = cl.loadClass("nz.test.loader.MyClass");
        myObj = (Executer) cls.newInstance();

        myObj.execute();

    }

    public static void compileClass(String message, String destination) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();

        StringWriter writer = new StringWriter();
        PrintWriter out = new PrintWriter(writer);
        out.println("package nz.test.loader;");
        out.println("public class MyClass implements Executer{");
        out.println("  public void execute() {");
        out.println("    System.out.println(\""+message+"\");");
        out.println("  }");
        out.println("}");
        out.close();
        JavaFileObject file = new JavaSourceFromString("nz.test.loader.MyClass", writer.toString());

        Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(file);

        List<String> optionList = new ArrayList<String>();

        JavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null,null);
        List<String> params = new ArrayList();
        params.add(destination);
        fileManager.handleOption("-d",params.iterator());
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, optionList, null, compilationUnits);

        boolean success = task.call();
        for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
            System.out.println(diagnostic.getCode());
            System.out.println(diagnostic.getKind());
            System.out.println(diagnostic.getPosition());
            System.out.println(diagnostic.getStartPosition());
            System.out.println(diagnostic.getEndPosition());
            System.out.println(diagnostic.getSource());
            System.out.println(diagnostic.getMessage(null));

        }
        System.out.println("Success: " + success);

    }

}

class JavaSourceFromString extends SimpleJavaFileObject {
    final String code;

    JavaSourceFromString(String name, String code) {
        super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension),Kind.SOURCE);
        this.code = code;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return code;
    }
}