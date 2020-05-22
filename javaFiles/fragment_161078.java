import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class AnotherClassLoaderRunner {

    private static final String nameOfDemoClass = "ByeWorld";

    public static void main(String[] args) throws ClassNotFoundException, SecurityException, NoSuchMethodException,
            IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        // Start compilation and loading of first class.
        String sourceCode = "public class " + nameOfDemoClass + " {\n" + "  public static void main(String args[]) {\n"
                + "    System.out.println(\"First of our Compiled Class\");\n" + "  }\n" + "}";
        AnotherClassLoader classLoader = new AnotherClassLoader(AnotherClassLoaderRunner.class.getClassLoader(), nameOfDemoClass);
        Class<?> myclass = classLoader.loadClass(nameOfDemoClass,sourceCode);
        Method mymethod = myclass.getDeclaredMethod("main", new Class[] { String[].class });
        mymethod.invoke(null, new Object[] { null });

        // Start compilation and loading of second class.
        sourceCode = sourceCode.replace("First of our Compiled Cla", "Second of our Compiled Cla");
        classLoader = new AnotherClassLoader(AnotherClassLoaderRunner.class.getClassLoader(), nameOfDemoClass);
        myclass = classLoader.loadClass(nameOfDemoClass,sourceCode);
        mymethod = myclass.getDeclaredMethod("main", new Class[] { String[].class });
        mymethod.invoke(null, new Object[] { null });
    }
}

class AnotherClassLoader extends ClassLoader {

    private static final String pathToClassDirectory = "file:/Users/*********/Documents/workspace/Dynamic/src/";
    private String targetName;

    public AnotherClassLoader(ClassLoader parent, String target) {
        super(parent);
        targetName = target;
    }

    public Class<?> loadClass(String name, String compileme) throws ClassNotFoundException {
        if (!targetName.equals(name)) {
            return super.loadClass(name);
        }
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        JavaFileObject file = new JavaSourceFromString(name, compileme);
        Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(file);
        CompilationTask task = compiler.getTask(null, null, new DiagnosticCollector<JavaFileObject>(), null, null,
                compilationUnits);
        task.call();
        // THE CLASSFILE FOR THE SYSTEM EXSITS AT THIS POINT, thought how it
        // chooses the directory escapes me.
        try {
            String url = pathToClassDirectory + targetName + ".class";
            URL myUrl = new URL(url);
            URLConnection connection = myUrl.openConnection();
            InputStream input = connection.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int data = input.read();
            while (data != -1) {
                buffer.write(data);
                data = input.read();
            }
            input.close();
            byte[] classData = buffer.toByteArray();

            return defineClass(targetName, classData, 0, classData.length);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class JavaSourceFromString extends SimpleJavaFileObject {
    final String code;

    JavaSourceFromString(String name, String code) {
        super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
        this.code = code;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return code;
    }
}