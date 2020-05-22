public static void sortFilesDesc(File[] files) {        
    File firstMostRecent = null;
    File secondMostRecent = null;
    File thirdMostRecent = null;
    for (File file : files) {
        if ((firstMostRecent == null)
                || (firstMostRecent.lastModified() < file.lastModified())) {
            thirdMostRecent = secondMostRecent;
            secondMostRecent = firstMostRecent;             
            firstMostRecent = file;
        } else if ((secondMostRecent == null)
                || (secondMostRecent.lastModified() < file.lastModified())) {
            thirdMostRecent = secondMostRecent;
            secondMostRecent = file;
        } else if ((thirdMostRecent == null)
                || (thirdMostRecent.lastModified() < file.lastModified())) {
            thirdMostRecent = file;
        }
    }
}