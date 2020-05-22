public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       FTS fileTreeSearch;
       String BaseDirectory = "E:" + File.separator;
       List<File> files = (fileTreeSearch = new FTS(BaseDirectory)).getFileList();
       System.out.println("Extracted " + String.valueOf(files.size()) + " files, from " + String.valueOf(fileTreeSearch.getSubDirectoryCount()) + " sub-directories of " + BaseDirectory);
       /* this commented out code would process all the extracted files
       for (File f: files) {
           System.out.println("File is " + f.getName() + "\t\t path " + f.getAbsolutePath());
       } 
       */
    }
}