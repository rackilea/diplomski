import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.Collections;
import java.util.Map;

public class SOQn47577298 {
    private final static Map<String, String> CREATE_TRUE =
            Collections.singletonMap("create", "true");

    interface ZipNameGenerator {
        String getName();
    }

    static void copyFileToZip(
            File sourceFolder,
            FilenameFilter filenameFilter,
            File destinationFolder,
            ZipNameGenerator zipNameGenerator,
            String fileEnding,
            boolean overwriteZipWithSameName) throws IOException {

        Path dir = Paths.get(destinationFolder.getAbsolutePath());
        Path destination = dir.resolve(zipNameGenerator.getName() + fileEnding);
        URI uri = URI.create("jar:" + destination.toUri());

        final Map<String, String> env;
        if (overwriteZipWithSameName || !Files.exists(destination)) {
            env = CREATE_TRUE;
        } else {
            env = Collections.emptyMap();
        }

        try (FileSystem fs = FileSystems.newFileSystem(uri, env)){
            for (String file : sourceFolder.list(filenameFilter)) {
                Path source = sourceFolder.toPath().resolve(file);
                Path dest = fs.getPath(file);
                Files.copy(source, dest);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        final File source = new File("D:\\Ausbildungsnachweise");
        final FilenameFilter nameFilter = (dir, name) -> name.endsWith(".doc");
        final File dest = new File("D:\\");
        final ZipNameGenerator zipNameGnr = () -> "test";
        final String fileEnding = ".zip";
        final boolean overwrite = false;

        copyFileToZip(source, nameFilter, dest, zipNameGnr, fileEnding, overwrite);
    }
}