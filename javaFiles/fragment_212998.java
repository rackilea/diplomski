package com.example;

public class WordReader {

   public void readWords() {
     InputStream is = getClass().getResourceAsStream("files/words.txt");
     StringBuilder sb = new StringBuilder();
     for(Scanner sc = new Scanner(is); sc.hasNext(); )  
         sb.append(sc.nextLine()).append('\n');

     String content = sb.toString();
   }
}