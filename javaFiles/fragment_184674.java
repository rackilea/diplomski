private Object loadJars(String processJar, String pluginJar, String className){

    File processJarFile = new File(processJar);
    File pluginJarFile = new File(pluginJar);


    Object instance = null;
    try {

        URL processJarPath = processJarFile.toURI().toURL();
        String processJarUrl = "jar:" + processJarPath + "!/";

        URL pluginJarPath = pluginJarFile.toURI().toURL();
        String pluginJarUrl = "jar:" + pluginJarPath + "!/";


        URL urls[] = { new URL(processJarUrl), new URL(pluginJarUrl) };
        URLClassLoader child = new URLClassLoader(urls);
        Class classToLoad = Class.forName(nomeClasse, true, child);
        instance = classToLoad.newInstance();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return instance;

}