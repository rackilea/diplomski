try {
    File file = new File("YOUR PATH");

    FileInputStream input = new FileInputStream(file);
    Properties properties = new Properties();
    properties.load(input);
    input.close();

    properties.setProperty("YOUR_KEY", "YOUR_VALUE");

    FileOutputStream output = new FileOutputStream(file);
    properties.store(output, null);
    output.close();
} catch (Exception e) {
    e.printStackTrace();
}