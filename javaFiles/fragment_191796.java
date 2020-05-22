import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class MyClassGenerator {

    static final String generatedClassName = "TestHello_" + System.currentTimeMillis();
    static final String javaFileName = generatedClassName + ".java";

    static URLClassLoader classLoader;

    public static void main(final String args[])
            throws MalformedURLException {
        generateClass();
        loadExecutableInterface();
        if (compileClass()) {
            System.out.println("Running " + generatedClassName + ":\n\n");
            final Executable ex = createExecutable();
            ex.execute();
        }
        else {
            System.out.println(javaFileName + " is bad.");
        }
    }

    public static void loadExecutableInterface()
            throws MalformedURLException {

        final File file = new File("."); // <-- the directory where the generated java class is defined

        try {
            classLoader = URLClassLoader.newInstance(new URL[] { file.toURI().toURL() }, Executable.class.getClassLoader());
            try {
                classLoader.loadClass("Executable");
            }
            catch (final ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        catch (final MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println(file.toURI().toURL());

    }

    public static void generateClass() {
        try {
            final FileWriter aWriter = new FileWriter(javaFileName, true);
            aWriter.write("public class " + generatedClassName + " implements Executable {");
            aWriter.write("\n");
            aWriter.write("\n");
            aWriter.write("    public void execute() {");
            aWriter.write("        System.out.println(\"Hello World!\");");
            aWriter.write("    }");
            aWriter.write("\n");
            aWriter.write("}");
            aWriter.flush();
            aWriter.close();
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean compileClass() {
        final String[] source = { "-classpath", "target/classes", javaFileName };
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        new sun.tools.javac.Main(baos, source[0]).compile(source);
        System.out.print(baos.toString());
        return (baos.toString().indexOf("error") == -1);
    }

    public static Executable createExecutable() {

        Executable instance = null;

        try {
            final Class<?> genClass = Class.forName(generatedClassName, true, classLoader);
            instance = (Executable) genClass.newInstance();
        }
        catch (final Exception e) {
            e.printStackTrace();
        }

        return instance;

    }

}