import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RecursiveFileDisplay {

    public static void main(String[] args) {
        File currentDir = new File("D:\\test"); // current directory
        File[] fileList = displayDirectoryContents(currentDir);
        readAndDeleteFiles(fileList);
    }

    public static File[] displayDirectoryContents(File dir) {
        File[] files = null;
        try {
            files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("directory:" + file.getCanonicalPath());
                    //recursive call to fetch file list in all levels of sub-directories
                    displayDirectoryContents(file); 
                } else {
                    System.out.println("     file:" + file.getCanonicalPath());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }
    public static void readAndDeleteFiles(File[] fileList){
        BufferedReader br = null;
        for(File file : fileList){
            if (!file.isDirectory()){
                try {

                    String sCurrentLine;

                    br = new BufferedReader(new FileReader(file.getCanonicalPath()));
                    if (br != null){
                        System.out.println("Reading file : " + file.getCanonicalPath());

                        while ((sCurrentLine = br.readLine()) != null) {
                            System.out.println(sCurrentLine);
                        }

                        br.close();
                        System.out.println("Finished reading file : " + file.getCanonicalPath());
                    }

                    //deleting file
                    if(file.delete()){
                        System.out.println(file.getCanonicalPath() + " is deleted!");
                    }
                    else{
                        System.out.println(file.getCanonicalPath() + " could not be deleted!"); 
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            else{
                //recursive call to fetch file list in all levels of sub-directories and then read & delete each of them
                readAndDeleteFiles(file.listFiles());
            }
        }
    }

}