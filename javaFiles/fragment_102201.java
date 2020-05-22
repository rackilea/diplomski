public int exec(Class<?> clazz) throws IOException,
                                           InterruptedException {
    String javaHome = System.getProperty("java.home");
    String javaBin = javaHome +
            File.separator + "bin" +
            File.separator + "java";

    /* This is where you want to set up your Classpath for the second app */
    String classpath = System.getProperty("java.class.path");
    String className = clazz.getCanonicalName();

    ProcessBuilder builder = new ProcessBuilder(
            javaBin, "-cp", classpath, className);

    Process process = builder.start();
    process.waitFor();
    return process.exitValue();
}