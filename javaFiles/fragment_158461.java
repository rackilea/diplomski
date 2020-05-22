public static void searchFile(String topFolderName, String type,
        String fileNamePatternRegExp, long timeOut) throws IOException {

    long startTimeStamp = Calendar.getInstance().getTimeInMillis();

    File topFolderOrFile = new File(topFolderName);
    Pattern fileNamePattern = Pattern.compile(fileNamePatternRegExp);

    searchFile(topFolderName, type, fileNamePattern, long timeOut);

}

public static void searchFile(String topFolderName, String type,
        Pattern fileNamePattern, long timeOut) throws IOException {
    //...
}