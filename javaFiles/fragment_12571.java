import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Example1 {
    public static void main(String[]args){
        final String extension = ".txt";
        final File sourceDir = new File("D:/Zip/");
        final File destinationDir = new File("D:/Archive/");
        File[] files = sourceDir.listFiles((File pathname) -> !pathname.getName().endsWith(extension));
        for(File f : files ){
            Path sourcePath      = Paths.get(sourceDir.getAbsolutePath()+"\\"+f.getName());
            Path destinationPath = Paths.get(destinationDir.getAbsolutePath()+"\\"+f.getName());

            try {
                Files.move(sourcePath, destinationPath,StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                //moving file failed.
                e.printStackTrace();
            }
        }        
    }        
}