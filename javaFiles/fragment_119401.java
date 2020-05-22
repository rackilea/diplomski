public static ArrayList<File> listLastModifiedFiles(File folder,
        long sleepDuration) throws Exception {

    ArrayList<File> newFileList = new ArrayList<File>();

    for (File fileEntry : folder.listFiles())
        if ((System.currentTimeMillis() - fileEntry.lastModified()) <= sleepDuration)
            newFileList.add(fileEntry);

    return newFileList;
}