import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearchFiles {
    public static void main(String[] args) {
        SearchFiles searchFilesObj = new SearchFiles();
        searchFilesObj.searchFiles(new File("/YourFolder/"), "TempFileName");
    }
    private List<String> searchFiles(File file,String fileNameToSearch) { // Directory name should  be passed  here
        private List<String> listOfFiles = new ArrayList<String>();
        if (file.isDirectory()) {
            if (file.canRead()) {
                for (File currentFile : file.listFiles()) {
                    if (!currentFile.isDirectory()) {
                        if (fileNameToSearch.contains(currentFile.getName().toLowerCase())) {  // Also can use startsWith for the starting name         
                            listOfFiles.add(temp.getAbsoluteFile().toString());
                        }
                }
            }

        }
    }
    return listOfFiles;
  }

}