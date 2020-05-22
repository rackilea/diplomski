public class MyClass {
    /**
     * Creates a {@code URLClassLoader} from JAR files found in the
     * globalclasspath directory, assuming that globalclasspath is in
     * {@code System.getProperty("java.class.path")}.
     */
    private static URLClassLoader createURLClassLoader() {
        Collection<String> resources = ResourceList.getResources(Pattern.compile(".*\\.jar"));
        Collection<URL> urls = new ArrayList<URL>();
        for (String resource : resources) {
            File file = new File(resource);
            // Ensure that the JAR exists
            // and is in the globalclasspath directory.
            if (file.isFile() && "globalclasspath".equals(file.getParentFile().getName())) {
                try {
                    urls.add(file.toURI().toURL());
                } catch (MalformedURLException e) {
                    // This should never happen.
                    e.printStackTrace();
                }
            }
        }
        return new URLClassLoader(urls.toArray(new URL[urls.size()]));
    }

    public static void main(String[] args) {
        URLClassLoader classLoader = createURLClassLoader();
        System.out.println(classLoader.getResource("mine.properties"));
    }
}