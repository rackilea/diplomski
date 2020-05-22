public void saveFile(File newFile)
{
    File file = newFile;

    if(! file.exists()){
        File dir = file.getParentFile();
        if(! dir.exists()) {
            if(dir.mkdirs()) {
                System.out.println("parent directory " 
                    + dir.getPath() + " created");
            }
            if(! dir.isDirectory()){
                throw new IllegalStateException("Unable to create directory "
                 + dir.getPath());
            }
        }
    } else {
        if(file.isDirectory()){
            throw new IllegalStateException("Save file can not be a folder");
        }
    }

    // ...

    System.out.println("Save file " + file.getPath() + " created");
}