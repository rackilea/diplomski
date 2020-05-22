public class FileStorage{

    Map<String, File> fileMap;

    public FileStorage(){
        fileMap = new HashMap<String, File>();
    }

    public void addNewFile(File f, String fileName){
        if (fileMap.get(fileName) != null){
            // Do something if you do not want to erase previous file...
        else{
            fileMap.put(fileName, f);
        } 
    }

    public File getStoredFile(String fileName){
        File f = fileMap.get(fileName);
        if (f==null){
            // alert user the file is not found.
        }
        return f; 
    }

}