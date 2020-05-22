//add this imports    
import java.io.File;
import java.io.FilenameFilter;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public static File[] getFiles(String path) {
        File file = new File(path);

    // Get the subdirectories.
    String[] directories = file.list(new FilenameFilter() {
       @Override
       public boolean accept(File current, String name) {
         return new File(current, name).isDirectory();
       }
    });

    //Use a list to save the files returned from the recursive call
    List<File> filesList = new ArrayList<File>();

    if( directories != null){
        for (String dir : directories) {
            // Doing recursion
            filesList.addAll( Arrays.asList(getFiles(path + File.separator + dir)) );
        }
    }
    // Get the files inside the directory.
    FileFilter fileFilter = new FileFilter();  
    File[] files = file.listFiles(fileFilter);

    //Merge the rest of the files with the files
    //in the current dir
    if( files != null)
        filesList.addAll( Arrays.asList(files) );


    return filesList.toArray(new File[filesList.size()]);
}