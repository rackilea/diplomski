package nl.test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class ZipTest2 {

    @Test
    public void test() throws IOException {
        Path p = Paths.get("input.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(p)) {
            writer.write("text to compress");
        }
        Path p1 = createZipFile("p1.zip", p);
        createZipFile("p2.zip", p1);
    }

    private Path createZipFile(String compressedFile, Path inputPath) {
        try {
            ZipFile zipFile = new ZipFile(compressedFile);
            ZipParameters parameters = new ZipParameters();

            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_FASTEST);
            zipFile.addFile(inputPath.toFile(), parameters);

            return Paths.get(compressedFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}