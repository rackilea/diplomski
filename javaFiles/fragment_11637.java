public ObjectFactory(String jarFilePath) {
    try {
        File file= new File(jarFilePath);
        URL url = file.toURL();
        URL[] urls = new URL[]{url};
        cl = new URLClassLoader(urls, getClass().getClassLoader());
    } catch (Exception e) {
        e.printStackTrace();
    }  
}