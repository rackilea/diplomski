public static void markBelow(File folder){
    folder.deleteOnExit();
    for(File file: folder.listFiles()){
        if(file.isDirectory()){
            markBelow(file);
        } else {
            file.deleteOnExit();
        }
    }
}