package org.example;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        MyZip myZip = new MyZip();
        Path sourcePath = Paths.get("C:/Users/David/Desktop/a");
        Path targetPath = Paths.get("C:/Users/David/Desktop/zip/out.zip");
        Path zipPath = Paths.get("tadaa");
        myZip.zipFolder(sourcePath, targetPath.toFile(), zipPath);
    }

}