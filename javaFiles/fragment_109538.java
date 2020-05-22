public static void loadJarDll(String name) throws IOException {
    InputStream in = MyClass.class.getResourceAsStream(name);
    byte[] buffer = new byte[1024];
    int read = -1;
    File temp = File.createTempFile(name, "");
    FileOutputStream fos = new FileOutputStream(temp);

    while((read = in.read(buffer)) != -1) {
        fos.write(buffer, 0, read);
    }
    fos.close();
    in.close();

    System.load(temp.getAbsolutePath());
}