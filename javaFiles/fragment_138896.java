import java.util.*;

class Scanner1
{
   public static void main(String args[])
   {
     Scanner sc=new Scanner(System.in);
     String s;
     do
     {
        s=sc.nextLine();
           if(!(s.equalsIgnoreCase("y")||s.equalsIgnoreCase("n")||s.equalsIgnoreCase("")))
        {
            System.out.println("Please Enter valid input");
        }

    }while(!(s.equalsIgnoreCase("y")||s.equalsIgnoreCase("n")||s.equalsIgnoreCase("")));

    }
}