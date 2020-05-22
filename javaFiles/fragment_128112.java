import java.util.regex.*; 

public class RemoveComments { 

   public static void main(String[] args){ 

      String[] lines = {"This is important information...  //but this is a comment", "This is more important info...  //and this is another comment"}; 
      Pattern pattern = Pattern.compile("//.*$", Pattern.DOTALL); 

      for(String line : lines) { 
          Matcher matcher = pattern.matcher(line); 

          System.out.println("Original: " + line); 
          line = matcher.replaceFirst(""); 

          System.out.println("New: " + line); 
      } 
   } 
}