import java.io.File;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

public class FinalZipCreator {
public static void processList(URI uri, Map<String, String> env, String path)
        throws Throwable {
    try (FileSystem zipfs = FileSystems.newFileSystem(uri, env)) {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        int index = path.length();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                Path externalTxtFile =Paths.get(listOfFiles[i].toString());
                Path pathInZipfile = zipfs.getPath(listOfFiles[i]
                        .toString().substring(index));
                // copy a file into the zip file
                Files.copy(externalTxtFile, pathInZipfile,
                        StandardCopyOption.REPLACE_EXISTING);
            } else if (listOfFiles[i].isDirectory()) {
                Path externalTxtFile = Paths.get(listOfFiles[i].toString());
                Path pathInZipfile = zipfs.getPath(listOfFiles[i]
                        .toString().substring(index));
                // copy a file into the zip file
                Files.copy(externalTxtFile, pathInZipfile,
                        StandardCopyOption.REPLACE_EXISTING);
                File folder2 = new File(listOfFiles[i].toString());
                File[] listOfFiles2 = folder2.listFiles();
                int index2 = listOfFiles[i].toString().length();
                for (int e = 0; e < listOfFiles2.length; e++) {
                    if (listOfFiles2[i].isFile()) {
                        Path externalTxtFile2 = Paths.get(listOfFiles2[e].toString());
                        Path pathInZipfile2 = zipfs.getPath(listOfFiles2[e]
                                .toString().substring(index2));
                        // copy a file into the zip file
                        Files.copy(externalTxtFile2, pathInZipfile2,
                                StandardCopyOption.REPLACE_EXISTING);
                    }
            }
        }

    }}

}