import junit.framework.JUnit4TestAdapter;
import junit.framework.TestSuite;

import java.io.File;
import java.io.IOException;

public class DirectoryTestSuite {
    static final String rootPath = "proj\\src\\test\\java\\";
    static final ClassLoader classLoader = DirectoryTestSuite.class.getClassLoader();

    public static TestSuite suite() throws IOException, ClassNotFoundException {
    final TestSuite testSuite = new TestSuite();
    findTests(testSuite, new File(rootPath));
    return testSuite;
    }

    private static void findTests(final TestSuite testSuite, final File folder) throws IOException, ClassNotFoundException {
    for (final String fileName : folder.list()) {
        final File file = new File( folder.getPath() + "/" +fileName);
        if (file.isDirectory()) {
        findTests(testSuite, file);
        } else if (isTest(file)) {
        addTest(testSuite, file);
        }
    }
    }

    private static boolean isTest(final File f) {
    return f.isFile() && f.getName().endsWith("Test.java");
    }

    private static void addTest(final TestSuite testSuite, final File f) throws ClassNotFoundException {
    final String className = makeClassName(f);
    final Class testClass = makeClass(className);
    testSuite.addTest(new JUnit4TestAdapter(testClass));
    }

    private static Class makeClass(final String className) throws ClassNotFoundException {
    return (classLoader.loadClass(className));
    }

    private static String makeClassName(final File f) {
    return f.getPath().replace(rootPath, "").replace("\\", ".").replace(".java", "");
    }
}