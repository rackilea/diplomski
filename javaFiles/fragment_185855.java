String javaHome = System.getProperty("java.home");
String javaBin = javaHome +
        File.separator + "bin" +
       File.separator + "java";
String classpath = System.getProperty("java.class.path");

ProcessBuilder builder = new ProcessBuilder(
        javaBin, "-cp", classpath, "com.example.MinecraftGame");