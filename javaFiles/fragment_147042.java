private Properties properties = new Properties();

//...
String name = JOptionPane.showInputDialog("What is your name?");
properties.set("user.name", name);

//...
protected void savePropeties() throws IOException {
    try (OutputStream os = new FileOutputStream(new File("User.properties"))) {
        properties.store(os, "User details");
    }
}

protected void loadPropeties() throws IOException {
    try (InputStream is = new FileInputStream(new File("User.properties"))) {
        // Note, this will overwrite any previously existing
        // values...
        properties.load(is);
    }
}