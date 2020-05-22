public void createXmlFile(String saveFilePath, XmlSuite suiteName) {
    File file = new File(saveFilePath);
    FileWriter writer = null;
    try {
        writer = new FileWriter(file);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    try {
        writer.write(suiteName.toXml());
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    System.out.println(suiteName.toXml());
    try {
        writer.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}