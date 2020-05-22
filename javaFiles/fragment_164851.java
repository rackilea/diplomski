package mypack;
import java.io.*;
import java.util.regex.*;


public class AnchorIssue {

    static int count=0;
    public static void main(String[] args) throws IOException {
        Pattern pFinder = Pattern.compile("<a name=\\\".*?\\\"(\\/><span)(.*)(<\\/span>)");
        BufferedReader r = new BufferedReader
                  (new FileReader("file.txt"));
                  String line;
                  while ((line =r.readLine()) != null) {
                     Matcher m1= pFinder.matcher(line);
                     while (m1.find()) {
                        int start = m1.start(0);
                        int end = m1.end(0);
                        ++count;

//                  Use CharacterIterator.substring(offset, end);
                        String actual=line.substring(start, end);
                        System.out.println(count+"."+"Actual String : "+actual);


                        actual= actual.replaceAll(m1.group(1),"><span");
                     System.out.println("\n");

                        actual= actual.replaceAll(m1.group(3),"</span></a>");

                    System.out.println(count+"."+"Replaced : "+actual);
                    System.out.println("\n");
                    System.out.println("---------------------------------------------------");


      }

} 
    r.close();            
    }
}