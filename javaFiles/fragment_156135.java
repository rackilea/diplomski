import java.io.File;
    import java.io.IOException;
    import java.nio.file.Files;
    import java.nio.file.Path;

    public class FileCopy {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{
        File sourceDir = new File("c:/tmp/pics");
        if (sourceDir.exists()) { // if we have to copy something

            File destDir = new File(System.getProperty("user.home") + "/desktop/pics");
            destDir.mkdirs(); // ensure that we do have output directory

            // do copy with nio lib
            Path destPath = destDir.toPath();
            doCopy(sourceDir, destPath);
        } else {
            System.out.println("Source directory doesn't exists!");
        }

    }

    /**
     * Do copy.
     *
     * @param sourceDir the source dir
     * @param destPath the dest path
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static void doCopy(File sourceDir, Path destPath) throws IOException{
        for (File sourceFile : sourceDir.listFiles()) {
            if (sourceFile.isDirectory()){
                File dPath = destPath.resolve(sourceFile.getName()).toFile();
                if (!dPath.exists()){
                    dPath.mkdir();
                }
                doCopy(sourceFile, dPath.toPath());
            }
            else{
                Path sourcePath = sourceFile.toPath();
                Files.copy(sourcePath, destPath.resolve(sourcePath.getFileName()));
            }
        }
    }
}