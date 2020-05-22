File preprFile = new File(directory1/directory2/directory3/file.xsd);
File directory = new File(directory1/directory2/directory3/);

try {
// Create file if it doesn't already exist;
    directory.mkdirs();
    preprFile.createNewFile();                              
} catch (Exception e) {
    e.printStackTrace();
}