JarURLConnection connection = (JarURLConnection) url.openConnection();
JarFile file = connection.getJarFile();
Enumeration<JarEntry> entries = file.entries();
while (entries.hasMoreElements()) {
    JarEntry e = entries.nextElement();
    if (e.getName().startsWith("com")) {
        // ...
    }
}