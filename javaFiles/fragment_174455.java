import java.io.*;
  import java.lang;
  public class
  { 
     //Compares response to the string representations of all numbers between 1 and numOptions, inclusive. 
     //Returns the matching integer or -1 otherwise.
     public static int parseResponse(String response, int numOptions) 
     {
          for(int i=1;i<=numOptions;i++) {
              if(response.equals(Integer.toString(i))) return i;
          }
          return -1;
     }

     public static void main()throws IOException
     { 
         InputStreamReader read =new InputStreamReader (System.in);
         BufferedReader in =new BufferedReader (read);
         System.out.println(" Select your category");
         System.out.println(" 1. Food");
         System.out.println(" 2. National");
         System.out.println("");
         System.out.println(" Enter your choice");

         //New code
         int choice=-1;
         while(choice==-1) {
             choice=parseResponse(in.readLine(),2);
             if(choice==-1)
             {
                 System.out.println(" Invalid input. Please enter a number between 1-2");
             }
         }


         if(choice==1)//food category
         { 
             int score = 0;
             System.out.println("what are dynamites made?");
             System.out.println("1. peanuts");System.out.println("2. grapes");
             System.out.println("3. flaxseeds");System.out.println("4. fish");
             System.out.println(" Enter your choice");

             //New code
             int food1=-1;
             while(food1==-1) {
                 food1=parseResponse(in.readLine(),4);
                 if(food1==-1)
                 {
                     System.out.println(" Invalid input. Please enter a number between 1-4");
                 }
             }

             if(food1==1)
             { System.out.println(" Correct answer");
               score=score+10
             }
             else
             { 
               System.out.println(" Wronge answer");
               score=score+0
             }
             //then i have the second question with the same format
        } 
        if(choice==2)//natioanl category with the same format as above
        {//two question with if else statements in them 
        }
    }
}// also help me where to add the try and catch statements