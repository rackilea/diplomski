content = new Scanner(new File("plugins/" + listOfFiles[i].getName().replaceAll(".jar", "") + "/" + "plugin.cfg")).useDelimiter("\\Z").next();

URL[] urls = null;
try {
    File dir = new File("plugins/" + listOfFiles[i].getName());
    URL url = dir.toURL();
    urls = new URL[]{url};
} catch (MalformedURLException e) {

}

try {
    ClassLoader cl = new URLClassLoader(urls);
    Class cls = cl.loadClass(content.replaceAll("Main-Class:", ""));
    Method enable = cls.getMethod("enable", (Class<?>[]) null);
    enable.invoke(enable, null);
}catch (Exception e) {
    System.out.println("One of the installed plugins might have an invalid plugin.cfg.");
}