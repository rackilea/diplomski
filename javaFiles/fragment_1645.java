public static HashMap<String,File[]> mapFiles(File directory){
    HashMap<String,File[]> fileMap = new HashMap<String,File[]>();
    fileMap = mapFiles_Recursive(directory, fileMap);
    return fileMap;
}


private static HashMap<String,File[]> mapFiles_Recursive(File directory, HashMap<String,File[]> fileMap) {
    File[] inputContents = directory.listFiles();
    for (File content : inputContents){
        if (content.isDirectory()){
            File[] nestedContents = content.listFiles();
            if (areAllFiles(nestedContents)){
                String key = content.getPath();
                fileMap.put(key,nestedContents);
            } else {
                mapFiles(content, fileMap);
            }
        }
    }
    return fileMap;
}