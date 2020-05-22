public void getClassOfPackage(String packagenom) {

    final ClassLoader loader = Thread.currentThread()
            .getContextClassLoader();
    try {

        ClassPath classpath = ClassPath.from(loader); // scans the class path used by classloader
        for (ClassPath.ClassInfo classInfo : classpath.getTopLevelClasses(packagenom)) {
         if(!classInfo.getSimpleName().endsWith("_")){
            System.out.println(classInfo.getSimpleName());
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

}

public static void main(String[] args) {
    new TestMain().getClassOfPackage("org.myproject");
}