import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Enumeration;
import java.util.Objects;

import java.util.logging.Logger;
import java.util.logging.Level;

import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipException;

public class ZipUpdater {

    private static final Logger logger =
        Logger.getLogger(ZipUpdater.class.getName());

    private final Map<String, Path> changes;

    public ZipUpdater(Map<String, Path> changes) {
        this.changes = new LinkedHashMap<>(
            Objects.requireNonNull(changes, "Change list cannot be null"));
    }

    public void update(Path zipFile)
    throws IOException,
           ZipException {

        Objects.requireNonNull(zipFile, "Zip file cannot be null");

        Map<String, Path> changesNeeded = new LinkedHashMap<>(changes);

        Path newZipFilePath = Files.createTempFile(null, ".zip");

        try (ZipFile oldZipFile = new ZipFile(zipFile.toFile());
             ZipOutputStream newZipFile = new ZipOutputStream(
                new BufferedOutputStream(
                    Files.newOutputStream(newZipFilePath)))) {

            String comment = oldZipFile.getComment();
            if (comment != null) {
                newZipFile.setComment(comment);
            }

            Enumeration<? extends ZipEntry> oldEntries = oldZipFile.entries();
            while (oldEntries.hasMoreElements()) {
                ZipEntry entry = oldEntries.nextElement();

                String entryName = entry.getName();

                Path source = changesNeeded.remove(entryName);

                if (source != null) {
                    ZipEntry newEntry = new ZipEntry(entryName);
                    newEntry.setMethod(entry.getMethod());
                    newEntry.setTime(entry.getTime());
                    newEntry.setComment(entry.getComment());
                    newEntry.setExtra(entry.getExtra());
                    newZipFile.putNextEntry(newEntry);

                    logger.log(Level.INFO,
                        "Replacing entry \"{0}\" with contents of file \"{1}\"",
                        new Object[] { entryName, source });

                    Files.copy(source, newZipFile);
                } else {
                    ZipEntry newEntry = new ZipEntry(entry);
                    newZipFile.putNextEntry(newEntry);

                    logger.log(Level.FINE, "Copying entry {0}", entryName);

                    try (InputStream entryData = new BufferedInputStream(
                        oldZipFile.getInputStream(entry))) {

                        int b;
                        while ((b = entryData.read()) >= 0) {
                            newZipFile.write(b);
                        }
                    }
                }

                newZipFile.closeEntry();
            }
        }

        if (!changesNeeded.isEmpty()) {
            throw new IOException("The following entries were not found"
                + " in '" + zipFile + "': " + changesNeeded.keySet());
        }

        Files.move(zipFile, Paths.get(zipFile + ".old"),
            StandardCopyOption.REPLACE_EXISTING);
        Files.move(newZipFilePath, zipFile);
    }

    public static void main(String[] args)
    throws IOException,
           ZipException {

        if (args.length < 3 || (args.length % 2) != 1 ||
            args[0].equals("-?") ||
            args[0].equalsIgnoreCase("-h") ||
            args[0].equalsIgnoreCase("--help")) {

            System.err.println("Usage:");
            System.err.println(
                "java " + ZipUpdater.class.getName() + " <zipfile>"
                + " <zip-entry> <replacement-file>"
                + " [ <zip-entry> <replacement-file> ] ...");
            System.exit(2);
        }

        Path zipFile = Paths.get(args[0]);

        int argCount = args.length;
        Map<String, Path> changes = new LinkedHashMap<>(argCount / 2);
        for (int i = 1; i < argCount; i += 2) {
            String entry = args[i];
            Path replacement = Paths.get(args[i + 1]);
            changes.put(entry, replacement);
        }

        ZipUpdater updater = new ZipUpdater(changes);
        updater.update(zipFile);
    }
}