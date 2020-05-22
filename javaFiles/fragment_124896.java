import java.io.File;
import java.util.*;

public class ListFiles 
{
    public static void main(String[] args) 
    {

        // First directory path here.
        String path1 = ".";

        // Second directory path here.
        String path2 = "."; 

        // File class is very important.
        // If you did a simple Google search
        // Then you would have seen this class mentioned.
        File folder1 = new File(path1);
        File folder2 = new File(path2);

        // It gets the list of files for you.
        File[] listOfFiles1 = folder1.listFiles(); 
        File[] listOfFiles2 = folder2.listFiles(); 

        // We'll need these to store the file names as Strings.
        ArrayList<String> fileNames1 = new ArrayList<String>();
        ArrayList<String> fileNames2 = new ArrayList<String>();

        // Get file names from first directory.
        for (int i = 0; i < listOfFiles1.length; i++) 
        {
            if (listOfFiles1[i].isFile()) 
            {
                fileNames1.add(listOfFiles1[i].getName());
            }
        }

        // Get file names from second directory.
        for (int i = 0; i < listOfFiles2.length; i++) 
        {
            if (listOfFiles2[i].isFile()) 
            {
                fileNames2.add(listOfFiles2[i].getName());
            }
        }

        // Now compare
        // Loop through the two array lists and add your own logic.
    }
}