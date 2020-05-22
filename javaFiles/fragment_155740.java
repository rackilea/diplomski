File dir = new File("/tmp/");
File[] csvFiles = dir.listFiles(new FilenameFilter() {

    @Override
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith("csv"); //get all csv files
    }
});
//now load these csvFiles using whatever loaders
for (File csvFile :  csvFiles) {
    // I am guessing SCLoad requires a complete path.    
    new SCLoad().loadCSV(con,csvFile.getCanonicalPath(), ImportTable);
}