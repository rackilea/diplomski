public File[] GetFiles(String DirectoryPath) {
    File f = new File(DirectoryPath);
    f.mkdirs();
    File[] file = f.listFiles();
    return file;
}

public ArrayList<String> getFileNames(File[] file){
    ArrayList<String> arrayFiles = new ArrayList<String>();
     if (file.length == 0)
            return null;
        else {
            for (int i=0; i<file.length; i++) 
                arrayFiles.add(file[i].getName());
        }

    return arrayFiles;
}