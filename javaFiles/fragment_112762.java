JarFile jarFile = new JarFile(file);
// lets get a reference to the .class-file contained in the JAR
ZipEntry zipEntry = jarFile.getEntry(className.replace(".", "/")+".class");
if (zipEntry == null) {
    jarFile.close();
    return null;
}
// with our valid reference, we are now able to get the bytes out of the jar-archive
InputStream fis = jarFile.getInputStream(zipEntry);
byte[] classBytes = new byte[fis.available()];
fis.read(classBytes);