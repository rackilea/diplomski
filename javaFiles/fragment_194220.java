final InputStream jarStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("lib/xxxxx-1.0.0.jar");
        JarInputStream jfs = new JarInputStream(jarStream);
        List<String> list = new ArrayList<String>();
        JarEntry je = null;
        while (true) {
            je = jfs.getNextJarEntry();
            if (je == null) {
                break;
            }
            if (je.getName().endsWith(".class")) {
                String className = je.getName().replace("/", ".").replace(".class", "");
                    list.add(className);
            }
        }