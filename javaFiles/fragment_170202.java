public void listFiles(String directoryName, ArrayList<File> files) {
File directory = new File(directoryName);

// get all files from directory
File[] fList = directory.listFiles();
for (File file : fList) {
   // verify if file
    if (file.isFile()) {
        files.add(file);
    // verify if directory 
    } else if (file.isDirectory()) {
        listFiles(file.getAbsolutePath(), files);
    }
}
}