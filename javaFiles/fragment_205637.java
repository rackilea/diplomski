List<String> classNames = new ArrayList<String>();
ZipInputStream zip = new ZipInputStream(new FileInputStream("/path/to/jar/file.jar"));
for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
    if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
        // This ZipEntry represents a class. Now, what class does it represent?
        String className = entry.getName().replace('/', '.'); // including ".class"
        classNames.add(className.substring(0, className.length() - ".class".length()));
    }
}