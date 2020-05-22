import java.io.*;
import org.apache.poi.xwpf.usermodel.*;

import java.awt.Desktop;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class WordReadAndWrite {

 public static void main(String[] args) throws IOException, InvalidFormatException {

  XWPFDocument doc = new XWPFDocument(new FileInputStream("source.docx"));

  for (XWPFParagraph p : doc.getParagraphs()) { //go through all paragraphs
   int runNumber = 0;
   while (runNumber < p.getRuns().size()) { //go through all runs, we cannot use for each since we will possibly insert new runs
    XWPFRun r = p.getRuns().get(runNumber);
    String runText = r.getText(0);
    if (runText != null && runText.contains("a")) { //if we have a run with an "a" in it, then
     char[] runChars = runText.toCharArray();
     StringBuffer sb = new StringBuffer();
     for (int charNumber = 0; charNumber < runChars.length; charNumber++) { //go through all characters in that run     
      if (runChars[charNumber] == 'a') { //if the charcter is an 'a' then      
       r.setText(sb.toString(), 0); //set all characters, which are current buffered, as the text of the actual run
       r = p.insertNewRun(++runNumber); //insert new run for the '@' as the replacement for the 'a'
       r.setText("@", 0);
       r.setColor("DC143C");
       r = p.insertNewRun(++runNumber); //insert new run for the next characters
       sb = new StringBuffer(); //empty buffer
      } else {
       sb.append(runChars[charNumber]); //buffer all characters which are not 'a's
      }
     }
     r.setText(sb.toString(), 0); //set all characters, which are current buffered, as the text of the actual run
    }
    runNumber++;
   }
  }


  doc.write(new FileOutputStream("result.docx"));
  doc.close();

  System.out.println("Done");
  Desktop.getDesktop().open(new File("result.docx"));

 }
}