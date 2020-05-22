public class CompliedClass {
    public static void main(String[] args) {

        String source = "public class Solution{" + "public int add(){" + "return 1+1;" + "}" + "}";

        File folder = new File("./src");
        File sourceFile = new File(folder, "Solution.java");

        try {
            Files.write(sourceFile.toPath(), source.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sourceFile.getPath());
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        if (compiler == null) {
            System.out.println("JDK required (running inside of JRE)");
        } else {
            System.out.println("you got it!");
        }

        int compilationResult = compiler.run(null, null, null, sourceFile.getPath());
        if (compilationResult == 0) {
            System.out.println("Compilation is successful");
        } else {
            System.out.println("Compilation Failed");
        }

        try {
            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] {folder.toURI().toURL() });
            Class<?> cls = Class.forName("Solution", true, classLoader);
            Object instance = cls.newInstance();
            Method method = cls.getDeclaredMethod("add", null);
            System.out.println(method.invoke(instance, null));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("something wrong");
        }

    }
}