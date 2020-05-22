File f = "\\classesfolder\\";

ClassLoader loader = new URLClassLoader(new URL[] { f.toURI().toURL() }, getClass().getClassLoader(););

FilenameFilter filter = new FilenameFilter() {
    public boolean accept(File dir, String name) {
        return name.endsWith(".class");
    }
  };
for (File classFile : f.listFiles(filter)) {
    try {
        // Remove the file extension
        String filename = classFile.getName().substring(0, filename.length() - 6);
        Class<? implements Operator> cls = loader.loadClass(filename);
        Operator operatorClass = (Operator) cls.newInstance();
        operatorMap.put(operatorClass.operator, operatorClass);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}