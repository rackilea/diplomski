public static class PatternFileFilter implements FileFilter {

    private Pattern fileNamePattern;

    public PatternFileFilter(Pattern fileNamePattern) {

        this.fileNamePattern = fileNamePattern;

    }

    @Override
    public boolean accept(File pathname) {

        return fileNamePattern.matcher(pathname.getName()).find() || pathname.isDirectory();

    }

    public Pattern getPattern() {
        return fileNamePattern;
    }
}

public static void searchFile(File topFolderOrFile, String type, PatternFileFilter filter, long timeOut) throws IOException {

    long startTimeStamp = Calendar.getInstance().getTimeInMillis();

    if (topFolderOrFile.isDirectory()) {

        File[] subFoldersAndFileNames = topFolderOrFile.listFiles(filter);
        if (subFoldersAndFileNames != null && subFoldersAndFileNames.length > 0) {
            for (File subFolderOrFile : subFoldersAndFileNames) {

                if (ITEM_TYPE_FILE.equals(type) && subFolderOrFile.isFile()) {
                    System.out.println("File name matched ----- "
                            + subFolderOrFile.getName());
                }
                if (ITEM_TYPE_FOLDER.equals(type)
                        && subFolderOrFile.isDirectory() && filter.getPattern().matcher(subFolderOrFile.getName()).find()) {
                    System.out.println("Folder name matched ----- "
                            + subFolderOrFile.getName());
                }
                if (ITEM_TYPE_FILE_AND_FOLDER.equals(type) && filter.getPattern().matcher(subFolderOrFile.getName()).find()) {
                    System.out.println("File or Folder name matched ----- "
                            + subFolderOrFile.getName());
                }

                // You need to decide if you want to process the folders inline
                // or after you've processed the file list...

                if (subFolderOrFile.isDirectory()) {
                    long timeElapsed = startTimeStamp
                            - Calendar.getInstance().getTimeInMillis();
                    if (((timeOut * 1000) - timeElapsed) < 0) {
                        System.out
                                .println("Could not complete operation-- timeout");
                    } else {
                        searchFile(subFolderOrFile, type,
                                filter, (timeOut * 1000)
                                - timeElapsed);
                    }
                }
            }

        }

    }

}

public static void searchFile(String topFolderName, String type, String fileNamePatternRegExp, long timeOut) throws IOException {

    File topFolderOrFile = new File(topFolderName);
    Pattern fileNamePattern = Pattern.compile(fileNamePatternRegExp);

    searchFile(topFolderOrFile, type, new PatternFileFilter(fileNamePattern), timeOut);

}