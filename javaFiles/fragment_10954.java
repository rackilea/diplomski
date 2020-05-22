package filereader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files; 
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReader {
    /**
     * Run this class in a project setup where you have some files in the root
     * dir of the project. This main method will then read these files and 
     * create a HashMap with key(filename)->val(ArrayList<String> content) assignments.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    try {
        //this hashmap will store filename->content
        //you can access it by fileMap.get(filename) and it will return 
        //the corresponding ArrayList that you can then use to retrieve data
        //off of it by. Tha data is the deserialized content of the file.

        HashMap<String, ArrayList<String>> fileMap = new HashMap<>();
        List<Path> files;
        Files.list(new File(".").toPath()).
                filter((path) -> {
                    //add more filters here
                    return path.toFile().isFile();
                }
            ).forEach(path -> {
            try {
                ArrayList<String> content = (ArrayList<String>) Files.readAllLines(path);
                //if necessary, add some behaviour as to how the content should be formatted
                //here!
                fileMap.put(path.getFileName().toString(), content);
            } catch (IOException ex) {
                System.out.println("This hideous man is a hero! He maked IOEXCeptian ;-(");
                Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //lookie lookie content. just for testing.

        fileMap.forEach((k,v)  -> {
            System.out.println(k);
            System.out.println(v);
        });

    } catch (IOException ex) {
        Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
    }
}