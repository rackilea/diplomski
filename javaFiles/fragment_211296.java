public static void main(String... args) throws Exception {
    String source = "public class Test { static { System.out.println(\"test\"); } }";

    File root = new File("/test");
    File sourceFile = new File(root, "Test.java");
    Writer writer = new FileWriter(sourceFile);
    writer.write(source);
    writer.close();

    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    compiler.run(null, null, null, sourceFile.getPath());

    URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { root.toURI().toURL() });
    Class<?> cls = Class.forName("Test", true, classLoader);
}