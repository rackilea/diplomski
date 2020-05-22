String username = uName.getText().trim();
String pass = uPass.getText().trim();

// Read properties file.
Properties pro = new Properties();
try {

    final FileInputStream fileInputStream = new FileInputStream("conf.properties");
    pro.load(new FileInputStream("conf.properties"));
    fileInputStream.close();
    pro.setProperty("user", username);
    pro.setProperty("pass", pass);
    String user = pro.getProperty("user");
    System.out.println(user);

    final FileOutputStream fileOutputStream = new FileOutputStream("conf.properties");
    pro.store(fileOutputStream, null);
    fileOutputStream.close();
    System.out.println("successful .......");

} catch (IOException ex) {
    ex.printStackTrace();
}