import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.apache.commons.io.FilenameUtils;

public class MainClass {
    public static void main(String[] args) {
        SplitFile("c:\\test\\test.vcf", "END:VCARD", "c:\\test\\output");
    }

    private static void SplitFile(String fileName, String seperateChars, String destFolder) {

        try {
            Path p = Paths.get(fileName);// or
                                            // FileSystems.getDefault().getPath(fileName)
            String lines = new String(Files.readAllBytes(p));
            String fName = FilenameUtils.getBaseName(p.toString());
            String fExt = FilenameUtils.getExtension(p.toString());
            int fCounter = 0;
            int beginMark = 0;
            int endMark = 0;
            destFolder = FilenameUtils.normalizeNoEndSeparator(destFolder);
            while ((endMark = lines.indexOf(seperateChars, beginMark)) >= 0) {
                fCounter++;
                String buf = lines.substring(beginMark, endMark + seperateChars.length());
                String fOut = String.format("%s\\%s%05d.%s", destFolder, fName, fCounter, fExt);
                System.out.println(fOut);
                beginMark = endMark + seperateChars.length();
                Files.write(Paths.get(fOut), buf.getBytes(), StandardOpenOption.CREATE);
                endMark = -1;

            }
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}