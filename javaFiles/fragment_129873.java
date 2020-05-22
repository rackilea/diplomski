import java.util.Scanner;
public class MyClass {
    public static void main(String args[]) {
       String y;
      int x=0;
      int found = 0; //to identify the index 

      Scanner s = new Scanner(System.in);

      String[] names = {"bob", "maxwell", "charley", "tomtomjack"};

      System.out.print("Enter String Name:");
         y=s.nextLine();

            for (String a: names){
               if (a.equals(y)) 
                { 
                    System.out.println("index of "+a+" is :"+x);   
                    found++; // increment if found 
                }

                x++;//iterate each time to get the index
            }

            if(found == 0)// check if it is not found
                 System.out.println("NOT FOUND");
    }
}