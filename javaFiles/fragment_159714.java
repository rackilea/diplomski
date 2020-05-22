URL[] urls;
List<URL> listOfURL = new ArrayList<>();
SourceSetContainer ssc = getProject().getConvention().getPlugin(JavaPluginConvention.class).getSourceSets();
File classesDir = ssc.getByName("main").getOutput().getClassesDir();
listOfURL.add(classesDir.toURI().toURL());
urls = listOfURL.toArray(new URL[0]);
final ClassLoader loader = new URLClassLoader(urls);