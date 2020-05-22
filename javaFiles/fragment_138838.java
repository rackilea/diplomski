private static Map<String, Boolean> getEngines() throws Exception {
    Map<String, Boolean> result = new HashMap<String, Boolean>();
    String[] pathElements = System.getProperty("java.class.path").split(System.getProperty("path.separator"));
    for (String pathElement : pathElements) {
        File resource = new File(pathElement);
        if (!resource.isFile()) {
            continue;
        }
        JarFile jar = new JarFile(resource);
        for (Enumeration<JarEntry> e = jar.entries(); e.hasMoreElements();) {
            JarEntry entry = e.nextElement();
            if(entry.isDirectory()) {
                continue;
            }
            if(!entry.getName().endsWith("Engine.class")) {
                continue;
            }
            String className = entry.getName().replaceFirst("\\.class$", "").replace('/', '.');
            try {
                if(BSFEngine.class.getName().equals(className)) {
                    continue;
                }
                Class<?> clazz = Class.forName(className);
                if(BSFEngine.class.isAssignableFrom(clazz) && !clazz.equals(BSFEngine.class)) {
                    result.put(className, true);
                }
            } catch (NoClassDefFoundError ex) {
                // ignore...
                result.put(className, false);
            }
        }
    }
    return result;
}