File findFile(String fileName, File[] files){
    for(File file : files){
        if(file.isDirectory) File f = findFile(fileName, file.listFiles());
        if(f!=null) return f;
        if(file.getName.equals(fileName)) return file;
    }
    return null;
}