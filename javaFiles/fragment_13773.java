package edu.uga.cs1302.mp3files;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Anderson13 {

    public static void main(String[] args) {
        TableOfContents toc = new TableOfContents();
        toc.addChapter("Introduction", 17);
        toc.addChapter("Variables", 11);
        toc.addChapter("If Statements", 1);
        toc.addSection("If", 7);
        toc.addSection("Else", 6);
        toc.addChapter("Loops", 12);
        toc.setLineLength(68);
        toc.printToConsole();
        toc.setLineLength(72);
        toc.printToFile("JavaBook.txt");
    }

}

class TableOfContents {
    private int chapcount = 0;
    private int seccount = 0;
    private int lenght;

    ArrayList<Integer> listOfInts = new ArrayList<Integer>();
    ArrayList<String> chapter = new ArrayList<String>();
    ArrayList<PaddedLine> padedLines=new ArrayList<>();

    public void addChapter(String title, int page) {
        chapcount++;
        chapter.add("Chapter " + chapcount + ":" + " " + title + " ");
        listOfInts.add(page);

        PaddedLine line = new PaddedLine("Chapter " + chapcount + ":" + " " + title + " ",String.valueOf(page));
        padedLines.add(line);

    }

    public void addSection(String title, int page) {
        seccount++;
        chapter.add("  Section " + seccount + ":" + " " + title + " ");
        listOfInts.add(page);

        PaddedLine line = new PaddedLine("  Section " + seccount + ":" + " " + title + " ",String.valueOf(page));
        padedLines.add(line);
    }


    public void setLineLength(int lenght) {
        this.lenght = lenght;

    }



    public void printToConsole() {
        for (int i = 0; i < listOfInts.size(); i++) {
            System.out.println( chapter.get(i)+padedLines.get(i).getString(lenght)
                    + listOfInts.get(i));
        }
    }

    public void printToFile(String filename) {
        try {
            FileWriter myFile = new FileWriter(filename);
            PrintWriter out = new PrintWriter(myFile);
            for (int i = 0; i < listOfInts.size(); i++) {
                out.println(chapter.get(i) + padedLines.get(i).getString(lenght)
                        + +listOfInts.get(i));
            }
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

class PaddedLine {
    private String beforeDots; // e.g. "Chapter 2: Variables "
    private String afterDots; // e.g. " 18"

    // Helper method to create a string of the right number of dots
    private String getDots(int numDots) {
        String dots = "";
        for (int i = 0; i < numDots; i++)
            dots += ".";
        return dots;
    }

    // Constructor only needs strings for either side of the padding
    public PaddedLine(String beforeDots, String afterDots) {
        this.beforeDots = beforeDots;
        this.afterDots = afterDots;
    }

    // Select the line length when getting the string by using the helper
    public String getString(int lineLength) {
        int lengthUsed = beforeDots.length() + afterDots.length();
        return getDots(lineLength - lengthUsed) ;
    }

}