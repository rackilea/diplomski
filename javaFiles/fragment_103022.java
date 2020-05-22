package eu.webfarmr.stackoverflow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The goal of this class is to read lines from a text file which contain
 * vertical bars and extract the fields separated by these tabs
 * 
 * @author djob
 * 
 */
public class FileLACSReader {

    private final static String SEPARATOR = "\\|";

    /**
     * 
     * @param args
     */
    public static void main(String args[]) throws Exception{
        List<String> lines = readContents("etc/sampleInput.txt");
        for (String input : lines) {
            String[] splitContent = input.split(SEPARATOR);
            for (String field : splitContent) {
                System.out.println(field);
            }
        }
    }

    public static List<String> readContents(String file)
            throws FileNotFoundException {
        List<String> textLines = new ArrayList<String>();
        FileInputStream stream = new FileInputStream(new File(file));
        Scanner scanner = new Scanner(stream);
        try {
            while (scanner.hasNextLine()) {
                textLines.add(scanner.nextLine());
            }
        } finally {
            scanner.close();
        }
        return textLines;

    }

}