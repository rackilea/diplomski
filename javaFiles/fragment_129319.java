private String readVideoLocation(String fullFilePath) throws Exception {
    File videoFile = new File(fullFilePath);
    if (!videoFile.exists()) {
        throw new FileNotFoundException("File " + fullFilePath + " not exists");
    }

    if (!videoFile.canRead()) {
        throw new IllegalStateException("No read permissions to file " + fullFilePath);
    }

    FileDataSourceImpl fileDataSource = new FileDataSourceImpl(fullFilePath); 
    IsoFile isoFile = new IsoFile(fileDataSource);

    AppleGPSCoordinatesBox locBox = Path.getPath(isoFile, "/moov[0]/udta[0]/meta[0]/ilst/©xyz");
    String xml = locBox.getValue();
    isoFile.close();
    return xml;
}