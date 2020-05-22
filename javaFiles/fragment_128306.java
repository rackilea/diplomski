public String getActualFilePath() {
    File givenFile = new File(filePath);
    File directory = givenFile.getParentFile();

    if(directory == null || !directory.isDirectory()) {
        return filePath;
    }


    File[] files = directory.listFiles();
    Map<String, String> fileMap = new HashMap<String, String>();

    for(File file : files) {                        
        if(file.isDirectory()){
            continue;
        }

        String absolutePath = file.getAbsolutePath();
        fileMap.put(absolutePath, StringUtils.upperCase(absolutePath));
    }

    int noOfOcc = 0;
    String actualFilePath = "";

    for(Entry<String, String> entry : fileMap.entrySet()) {
        if(filePath.toUpperCase().equals(entry.getValue())) {
            actualFilePath = entry.getKey();
            noOfOcc++;
        }
    }

    if(noOfOcc == 1) {
        return actualFilePath;
    }

    return filePath;
}