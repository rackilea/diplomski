import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Encoding {

    private static File removeLineFromFile2(String file) {

        File ret = null;

        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            File inFile = new File(file);
            if (!inFile.isFile()) {
                return ret;
            }

            ret = inFile;

            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "UTF-16"));

            String line = null;
            int totalRows=0;
            boolean continueMethod = false;
            //Count total number of rows in file
            while ((line = br.readLine()) != null) {
                //check if file is already formatted
                if (line.contains("List for Work")){
                    continueMethod = true;
                }

                if (line.toLowerCase().contains("</row>")){
                        ++totalRows;
                    }
                }

            if (continueMethod)
            {
                //Create a temporary file to hold the file with deleted lines.
                File tempFile = new File(inFile.getAbsolutePath() + ".2.tmp");
                pw = new PrintWriter(new OutputStreamWriter(
                    new FileOutputStream(tempFile), "UTF-16"));

                line = null;
                br.close();
                br = null;
                br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "UTF-16"));
                boolean ignoreMe = false;
                int rowCounter = 0;
                int rowCloser = 0;
                //begin cycling through file and writing to new one.
                while((line = br.readLine()) != null)
                {
                    //if runs into a row, count it.
                    if (line.toLowerCase().contains("<row>")){
                        rowCounter++;
                    }
                    if (line.toLowerCase().contains("</row>")){
                        rowCloser++;
                    }
                    //Delete the first two, and last two lines
                    if ((rowCounter == 1 ) || (rowCounter == 2) || (rowCounter == (totalRows-1)) || (rowCounter == totalRows))
                    {
                        ignoreMe = true;
                        //If it reached the last closing tag, exit out of this to allow it to write the rest of the file.
                        if (rowCloser==totalRows)
                            rowCounter++;                   
                    }
                    else
                    {
                        ignoreMe = false;
                    }
                    //copy over other lines
                    if (!ignoreMe)
                    {
                        pw.println(line);
                        pw.flush();
                    }
                }   
                br.close();
                pw.close();
                System.out.println("Temp file is: " + tempFile.getAbsolutePath());
                ret = tempFile;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ret;
    }

    private static File removeLineFromFile1(String file) {

        File ret = null;

        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            File inFile = new File(file);
            if (!inFile.isFile()) {
                return ret;
            }

            ret = inFile;

            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "UTF-16"));

            String line = null;
            int totalRows=0;
            boolean continueMethod = false;
            //Count total number of rows in file
            while ((line = br.readLine()) != null) {
                //check if file is already formatted
                if (line.contains("List for Work")){
                    continueMethod = true;
                }

                if (line.toLowerCase().contains("</row>")){
                        ++totalRows;
                    }
                }

            if (continueMethod)
            {
                //Create a temporary file to hold the file with deleted lines.
                File tempFile = new File(inFile.getAbsolutePath() + ".1.tmp");
                pw = new PrintWriter(new FileWriter(tempFile));

                line = null;
                br.close();
                br = null;
                br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "UTF-16"));
                boolean ignoreMe = false;
                int rowCounter = 0;
                int rowCloser = 0;
                //begin cycling through file and writing to new one.
                while((line = br.readLine()) != null)
                {
                    //if runs into a row, count it.
                    if (line.toLowerCase().contains("<row>")){
                        rowCounter++;
                    }
                    if (line.toLowerCase().contains("</row>")){
                        rowCloser++;
                    }
                    //Delete the first two, and last two lines
                    if ((rowCounter == 1 ) || (rowCounter == 2) || (rowCounter == (totalRows-1)) || (rowCounter == totalRows))
                    {
                        ignoreMe = true;
                        //If it reached the last closing tag, exit out of this to allow it to write the rest of the file.
                        if (rowCloser==totalRows)
                            rowCounter++;                   
                    }
                    else
                    {
                        ignoreMe = false;
                    }
                    //copy over other lines
                    if (!ignoreMe)
                    {
                        pw.println(line);
                        pw.flush();
                    }
                }   
                br.close();
                pw.close();
                System.out.println("Temp file is: " + tempFile.getAbsolutePath());
                ret = tempFile;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ret;
    }

    private static File removeLineFromFile(String file) {

        File ret = null;

        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            File inFile = new File(file);
            if (!inFile.isFile()) {
                return ret;
            }

            ret = inFile;

            br = new BufferedReader(new FileReader(file));

            String line = null;
            int totalRows=0;
            boolean continueMethod = false;
            //Count total number of rows in file
            while ((line = br.readLine()) != null) {
                //check if file is already formatted
                if (line.contains("List for Work")){
                    continueMethod = true;
                }

                if (line.toLowerCase().contains("</row>")){
                        ++totalRows;
                    }
                }

            if (continueMethod)
            {
                //Create a temporary file to hold the file with deleted lines.
                File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
                pw = new PrintWriter(new FileWriter(tempFile));

                line = null;
                br.close();
                br = null;
                br = new BufferedReader(new FileReader(file));
                boolean ignoreMe = false;
                int rowCounter = 0;
                int rowCloser = 0;
                //begin cycling through file and writing to new one.
                while((line = br.readLine()) != null)
                {
                    //if runs into a row, count it.
                    if (line.toLowerCase().contains("<row>")){
                        rowCounter++;
                    }
                    if (line.toLowerCase().contains("</row>")){
                        rowCloser++;
                    }
                    //Delete the first two, and last two lines
                    if ((rowCounter == 1 ) || (rowCounter == 2) || (rowCounter == (totalRows-1)) || (rowCounter == totalRows))
                    {
                        ignoreMe = true;
                        //If it reached the last closing tag, exit out of this to allow it to write the rest of the file.
                        if (rowCloser==totalRows)
                            rowCounter++;                   
                    }
                    else
                    {
                        ignoreMe = false;
                    }
                    //copy over other lines
                    if (!ignoreMe)
                    {
                        pw.println(line);
                        pw.flush();
                    }
                }   
                br.close();
                pw.close();
                System.out.println("Temp file is: " + tempFile.getAbsolutePath());
                ret = tempFile;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ret;
    }

    private static void parse(File file) {
        try {
            System.out.println("Parsing " + file.getAbsolutePath());

            SAXParserFactory parserFactor = SAXParserFactory.newInstance();
            SAXParser parser = parserFactor.newSAXParser();
            DefaultHandler handler = new DefaultHandler();

            parser.parse(file, handler);
        } catch (Exception ex) {
            System.out.println("An exception occurred: " + ex.getMessage());
        } finally {
            System.out.println("Done with " + file.getAbsolutePath());
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        System.out.println("getAndParseFile");
        String fileName=args[0];

        File file = new File(fileName);

        File f2 = removeLineFromFile2(file.getAbsolutePath());
        File f1 = removeLineFromFile1(file.getAbsolutePath());
        File f = removeLineFromFile(file.getAbsolutePath());
        System.out.println("Finished Removing Lines");

        parse(f2);
        parse(f1);
        parse(f);
    }
}