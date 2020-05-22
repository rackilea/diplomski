//Prints the Root directory
    public static void printPWD() {
        File dir1 = new File(".");
        try {
            System.out.println("Current dir : " + dir1.getCanonicalPath());
            dir1 = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }


     // Prints all files on the ClassPath to the system.out

    public static void printClasspathFiles() {
        ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();

        // Get the URLs
        URL[] urls = ((URLClassLoader) sysClassLoader).getURLs();

        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].getFile());
        }
    }

//prints the classpath to system.out
print printClasspath(){
       System.out.println(System.getProperty("java.class.path"));
}