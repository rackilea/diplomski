private String readOutputFile(String filename) {
    if (filename == null) {
        return null;
    }
    File file = new File(filename);
    StringBuilder sb = new StringBuilder();
    this.logger.log("Reading " + filename + " from filesystem.");
    try (FileInputStream fis = new FileInputStream(file)) {
        System.out.println("Total file size to read (in bytes) : " + fis.available());
        int content;
        while ((content = fis.read()) != -1) {
            sb.append((char) content);
        }
    } catch (IOException e) {
        this.logger.log("IO Problem reading ITMS output file\n");
        e.printStackTrace();
        throw new Error("io-error/itms-output");
    }
    this.logger.log("File content has been read in");
    String compressed = this.compress(this.cleanXML(sb.toString()));
    this.logger.log("The compressed file size is : " + compressed.length() + " bytes");

    return compressed;
}