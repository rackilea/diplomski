String[] approvedFiles = {"AAA.enc","LCQ.enc","MZXA.enc", "BBB.enc"};
Set<String> approvedFilesSet = new HashSet<String>(Arrays.asList(approvedFiles));
File folder = new File("test/");
File[] listOfFiles = folder.listFiles();

Map<String, File> haveFilesMap = new HashMap<>();
for (File file : listOfFiles) {
    if (file.isFile()) {
        haveFilesMap.put(file.getName(), file);
    }
}

// subtract the have files from the approved files
approvedFilesSet.removeAll(haveFilesMap.keySet());

for (String file : approvedFilesSet) {
    System.err.println("File " + file + " missing.");

    // uncomment the following if you also want to delete these extra files
    /*
    try {
        Files.delete(haveFilesMap.get(file).toPath());
    }
    catch (Exception e) {
        System.err.println("Error deleting file " + file);
    }
    */
}