package de.scrum_master.app;

import java.io.File;
import java.io.IOException;
import java.util.SortedMap;
import java.util.TreeMap;

public class Application {
    public static void main(String[] args) throws IOException {
        SortedMap<File, File[]> fileMappings = new TreeMap<>();
        fileMappings.put(
            new File("books.zip"),
            new File[] { new File("books.xml") }
        );
        fileMappings.put(
            new File("cds.zip"),
            new File[] { new File("cds.xml") }
        );
        fileMappings.put(
            new File("clothes.zip"),
            new File[] { new File("clothes.xml") }
        );

        ZipTool zipTool = new ZipTool();
        for (File zipFile : fileMappings.keySet())
            zipTool.addToZip(zipFile, fileMappings.get(zipFile));
        zipTool.addToZip(
            new File("archive.zip"),
            new File[] { new File("books.zip"), new File("cds.zip"), new File("clothes.zip") }
        );
    }
}