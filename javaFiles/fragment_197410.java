FileInputStream fin = new FileInputStream("OuterJar.jar");
JarInputStream jin = new JarInputStream(fin);
ZipEntry ze = null;
while ((ze = jin.getNextEntry()) != null) {
    if (ze.getName().endsWith(".jar")) {
        JarInputStream jin2 = new JarInputStream(jin);
        ZipEntry ze2 = null;
        while ((ze2 = jin2.getNextEntry()) != null) {
            // this is bit of a hack to avoid stream closing,
            // since you can't get one for the inner entry
            // because you have no JarFile to get it from 
            FilterInputStream in = new FilterInputStream(jin2) {
                public void close() throws IOException {
                    // ignore the close
                }
            };

            // now you can process the input stream as needed
            JavaClass clazz = new ClassParser(in, "").parse();
        }
    }
}