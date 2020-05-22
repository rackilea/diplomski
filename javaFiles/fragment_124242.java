public static void main(String[] args) throws Exception{
    //Folder to search
    File file = new File("C:\\Caixa");

    //Get all files from the folder (including subfolders)
    ArrayList<File> allFiles = new ArrayList<>();
    listFiles(file, allFiles);

    //Filter to use (1 day back from now)
    Calendar filter = Calendar.getInstance();
    filter.add(Calendar.DAY_OF_MONTH, -1);
    //Or 1 hour ago
    //filter.add(Calendar.HOUR_OF_DAY, -1);

    //List to keep the files found using the filter
    List<File> filesFound = new ArrayList<>();

    //Search code
    for (File fileSearched : allFiles) {
        BasicFileAttributes attrs = Files.readAttributes(Paths.get(fileSearched.getAbsolutePath()), BasicFileAttributes.class);      
        Calendar creationTime = Calendar.getInstance();
        creationTime.setTimeInMillis(attrs.creationTime().toMillis());

        if(creationTime.after(filter)){
            filesFound.add(fileSearched);
        }
    }

    //Listing files searched using the filter
    for (File fileFound : filesFound) {
        System.out.println("File found: "+fileFound);
    }
}

public static void listFiles(File directory, ArrayList<File> files) {
    File[] fList = directory.listFiles();
    for (File file : fList) {
        if (file.isFile()) {
            files.add(file);
        } else if (file.isDirectory()) {
            listFiles(file, files);
        }
    }
}