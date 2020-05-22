import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test{

    public static void main(String [] args){
        LinkedList<String> list = turnSentencesToList("sampleFile.txt");

        for(String s: list)
            System.out.println(s);  
    }

    private static LinkedList<String> turnSentencesToList(String fileName) {
        LinkedList<String> list = new LinkedList<>();
        String regex = "\\.|!|\\?";

        File file = new File(fileName);
        Scanner scan = null;
        try {
            scan = new Scanner(file);
            while(scan.hasNextLine()){
                String line = scan.nextLine().trim();

                String[] sentences = null;
                //we don't need empty lines
                if(!line.equals("")) {
                    //splits by . or ! or ?
                    sentences = line.split("\\.|!|\\?");

                    //gather delims because split() removes them
                    List<String> delims = getDelimiters(line, regex);

                    if(sentences!=null) {
                        int count = 0;
                        for(String s: sentences) {
                            list.add(s.trim()+delims.get(count));
                            count++;
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }finally {
            if(scan!=null)
                scan.close();
        }
        return list;
    }


     private static List<String> getDelimiters(String line, String regex) {
         //this method is used to provide a list of all found delimiters in a line
         List<String> allDelims = new LinkedList<String>();
         Pattern pattern = Pattern.compile(regex);
         Matcher matcher = pattern.matcher(line);

         String delim = null;
         while(matcher.find()) {
             delim = matcher.group();
             allDelims.add(delim);
         }

         return allDelims;     
    }
}