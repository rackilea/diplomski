import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.nio.file.spi.FileSystemProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class FileLockExample extends Application {

    @Override
    public void start(Stage arg0) throws Exception {
        ObservableList<File> files = retrieveFiles();
        deleteFiles(files);
        Platform.exit();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public ObservableList<File> retrieveFiles() {
        File[] files = new File(".").listFiles(new FilenameFilter() { 
            @Override 
            public boolean accept(File dir, String name) { 
                return name.endsWith(".zip");
            }
        });
        for (File file : files) {
            try {
                Map<String, Object> env = new HashMap<>();
                FileSystemProvider provider = getZipFSProvider();
                URI uri = new URI("jar:" + file.toURI());
                FileSystem zipfs = provider.newFileSystem(uri, env);
                List<String> jsonList = Files.readAllLines(zipfs.getPath("/project.json"));
                StringBuilder sb = new StringBuilder();
                for (String string : jsonList) {
                    sb.append(string);
                }
                String json = sb.toString();
                JSONObject obj = new JSONObject(json);
                String name = obj.getJSONObject("project").getString("name");
                String description = obj.getJSONObject("project").getString("description");
                System.out.println("Found project : " + name + " (" + description + ")");
            } catch (URISyntaxException use) {
                use.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return FXCollections.observableArrayList(files);
    }

    public void deleteFiles(ObservableList<File> files) {
        for (File file : files) {
            System.out.println("Deleting " + file.getName());
            file.deleteOnExit();
        }
    }

    private static FileSystemProvider getZipFSProvider() {
        for (FileSystemProvider provider : FileSystemProvider.installedProviders()) {
            if ("jar".equals(provider.getScheme()))
                return provider;
        }
        return null;
    }

}