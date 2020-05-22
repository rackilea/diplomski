package com.stackoverflow.questions.52012383;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSplitter {

    public static void parseFile(File file, String elementName) 
      throws ParserConfigurationException, IOException {

        List<Document> good = new ArrayList<>();
        List<String> bad = new ArrayList<>();

        String start-tag = "<" + elementName;
        String end-tag = "</" + elementName;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        StringBuffer buffer = new StringBuffer();
        String line;
        boolean append = false;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();

                if (line.startsWith(startTag)) {
                    append = true; //start accumulating content
                } else if (line.startsWith(endTag)) {
                    append = false;
                    buffer.append(line); 
                    //instead of the line above, you could hard-code the ending tag to compensate for bad data:
                    // buffer.append(endTag + ">");

                    try { // to parse as XML
                        builder = factory.newDocumentBuilder();
                        Document document = builder.parse(new InputSource(new StringReader(buffer.toString())));
                        good.add(document); // parsed successfully, add it to the good list

                        buffer.setLength(0); //reset the buffer to start a new XML doc

                    } catch (SAXException ex) {
                        bad.add(buffer.toString()); // something is wrong, not well-formed XML
                    }
                }

                if (append) { // accumulate content
                    buffer.append(line);
                }
            }
            System.out.println("Good items: " + good.size() + " Bad items: " + bad.size());
            //do stuff with the good/bad results...
        }
    }

    public static void main(String args[]) 
      throws ParserConfigurationException, IOException {
        File file = new File("/tmp/test.xml");
        parseFile(file, "Product");
    }

}