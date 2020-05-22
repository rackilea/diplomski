import java.io.*;

class Test {

    public static void main(String[] args) throws IOException {
         getAnswers();
    }

    public static void getAnswers() throws IOException {
         char answer;
         String listName;        
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
         System.out.println ("Would like to create a list (y/n)? ");
         answer = (char) br.read(); 
         br.readLine(); // <--    ADDED THIS 
         if (answer == 'y'){
             System.out.println("Enter the name of the list: ");
             listName = br.readLine();
             System.out.println ("The name of your list is: " + listName);
         }
         //insert code to save name to innerList
         else if (answer == 'n') { 
             System.out.println ("No list created, yet");
         }
         //check if lists exist in innerList
         // print existing classes; if no classes 
         // system.out.println ("No lists where created. Press any key to exit")
    }
}