import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

public class Read {

   public static void main(String[] args) {
      Set<String> textFile1 = readFiles("text1.txt");
      Set<String> textFile2 = readFiles("text2.txt");

      Set<String> difference = new HashSet<String>();

      // collect strings by dropping out every string that's not only letters
      // using the regex "[a-zA-Z]+"
      for (String t : textFile1) {
         if (!textFile2.contains(t) && t.matches("[a-zA-Z]+")) {
            difference.add(t);
         }
      }

      // sort
      List<String> dList = new ArrayList<String>(difference);
      Collections.sort(dList);

      // show
      for (String s : dList) {
         System.out.println(s);
      }
   }

   public static Set<String> readFiles(String filename) 
   {
      Set<String> words = new HashSet<String>();

      try {         
         for (String line : Files.readAllLines(new File(filename).toPath(), Charset.defaultCharset())) {    
            String[] split = line.split("\\s+");
            for (String word : split) {
               words.add(word.toLowerCase());
            }}} 
      catch (IOException e) {
         System.out.println(e);
      }
      return words;
   }
}