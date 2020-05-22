public class Main {

 static String[] words =  {"watch", "on", "youtube",":","Mickey","en","de","stomende","drol"};
 public static void main(String[] args){
 String output = "";

 for(int i = 0 ; i <= words.length-1 ; i++)
 {
    output += " " + words[i];
 }

 System.out.println(output);
 }
 }