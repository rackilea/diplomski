Path warDirectory = decompressWar(absolutePathFile);

File rootDir = new File(warDirectory.toAbsolutePath().toString());
File springBootDir = new File(warDirectory.toAbsolutePath().toString() + "/BOOT-INF/classes/");

List<URL> listaURL = new ArrayList<URL>();
listaURL.add(rootDir.toURI().toURL());
listaURL.add(springBootDir.toURI().toURL());

//This scan the BOOT-INF/lib folder and return a List<URL> with all the libraries.
listaURL.addAll(getURLfromSpringBootJar(warDirectory));


URL[] urls = new URL[listaURL.size()];
urls = listaURL.toArray(urls);
cl = new URLClassLoader(urls);

//This explore the JAR and load all the .class fulies to get the className.
resultClassesBean = loadJars(Collections.singletonList(pathJarFile), cl);

if(resultClassesBean != null && resultClassesBean.getListResultClasses() != null && !resultClassesBean.getListResultClasses().isEmpty()) {
    for(String clazz : resultClassesBean.getListResultClasses()) {
        cl.loadClass(clazz);
    }
}