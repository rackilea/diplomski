public static void main(String[] args) {
    String username = "bla";
    String pass = "blabla";

    // Read properties file.
    Properties pro = new Properties();
    try {
        File file = new File("/tmp/conf.properties");
        file.createNewFile();
        final FileInputStream fileInputStream = new FileInputStream(file);
        pro.load(fileInputStream);
        fileInputStream.close();
        pro.setProperty("user", username);
        pro.setProperty("pass", pass);
        String user = pro.getProperty("user");
        System.out.println(user);

        File toClose = new File("/tmp/conf.properties");
        final FileOutputStream fileOutputStream = new FileOutputStream(toClose);
        pro.store(fileOutputStream, null);
        fileOutputStream.close();

        System.out.println("successful .......");

    } catch (IOException ex) {
        ex.printStackTrace();
    }
}