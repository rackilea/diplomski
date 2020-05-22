AccessController.doPrivileged(new PrivilegedAction<Void>() {
    public Void run() {
        String dllName = "my.dll";
        File tmpDir = new File(System.getProperty("java.io.tmpdir"));
        File tmpFile = new File(tmpDir, dllName);

        try {
            InputStream in = getClass().getResourceAsStream(dllName);
            OutputStream out = new FileOutputStream(tmpFile);

            byte[] buf = new byte[8192];
            int len;
            while ((len = in.read(buf)) != -1) {
                out.write(buf, 0, len);
            }

            in.close();
            out.close();

            System.load(tmpFile.getAbsolutePath());

        } catch (Exception e) {
            // deal with exception
        }

        return null;
    }
});