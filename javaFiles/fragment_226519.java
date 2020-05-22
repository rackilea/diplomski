int index = path.indexOf('!');
if (index == -1) return url.openStream();
String jarPath = path.substring(0, index);
File jarFile = new File(new URL(jarPath).toURI());

if (!jarFile.exists()) return null;

String filePath = path.substring(index + 1);
if (filePath.startsWith("/")) {
    filePath = filePath.substring(1);
}

JarFile jar = new JarFile(jarFile);
return jar.getInputStream(jar.getJarEntry(filePath));