File file1 = new File("application.properties");//change path to outside//document\..\
File file2 = new File("version.properties");

try {
    FileReader reader = new FileReader(file2);
    Properties props = new Properties();
    props.load(reader);
    String prop2 = props.getProperty("Property2");
    reader.close();

    Properties props2 = new Properties();
    FileOutputStream fos = new FileOutputStream(file1);

    props2.setProperty("Property2", prop2);
    //writing properites into properties file from Java
    props2.store(fos, "wrote");
    fos.close();


} catch (FileNotFoundException ex) {
    // file does not exist
} catch (IOException ex) {
    // I/O error
}