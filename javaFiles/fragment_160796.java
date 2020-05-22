public Manuals() throws IOException {
    File physicalFile = new File("config.properties");
    if(!physicalFile.exists()) {
        physicalFile.createNewFile();
    }

    // at this point we either confirmed that the file exists or created it
    FileInputStream file = new FileInputStream(physicalFile);

    Properties configFile = new Properties(); 
    configFile.load(file);

    curPdf = new ArrayList();
    addPdf = new ArrayList();
    allPdf = new ArrayList();

    this.search = "";
}