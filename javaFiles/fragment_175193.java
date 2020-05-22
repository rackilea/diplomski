import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveProjectFolderMain {

    //Note: In eclipse your templates folder must be inside the eclipse project's root directory 
    //      in order for this path to be correct. E.g. myProject/templates
    //      If this program is run outside of eclipse it will look for a templates folder
    //      in the current working directory - the directory in which the jar resides.
    //      E.g. if you jar lives in C:\myProgram then your templates should live in
    //      C:\myProgram\templates (obviously this is a Windows file system example)
    private static final Path TEMPLATES_DIR = Paths.get("templates");

    public static void main(String[] args) {
        //Copies the template files to a new folder called "testProject"
        // creating the project folder if it does not exist.
        saveProjectDir(Paths.get("testProject"));
    }

    public static void saveProjectDir(Path dirToSaveTo){
        try {
            if(!Files.exists(dirToSaveTo)){
                System.out.println("The directory " + dirToSaveTo.toAbsolutePath() + " does not exist, it is being created.");
                Files.createDirectories(dirToSaveTo);
            }
            Files.walkFileTree(TEMPLATES_DIR, new CopyFileVisitor(dirToSaveTo));
        } catch (IOException e) {
            System.err.println("Unable to copy template files to the save location: " + dirToSaveTo.toAbsolutePath());
            e.printStackTrace();
        }
    }

}