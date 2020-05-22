import java.util.Scanner; 
public class Name 
{ 
    public static void main(String[] args) 
    { 
        Scanner kb = new Scanner(System.in); 
        longestName(kb); 
    } 
    public static void longestName(Scanner sc) 
    {
        System.out.println("Enter name, or type '-1' if you want to quit");

        String name=sc.nextLine();
        String biggestName="";

        while (!name.equals("-1")) 
        { 
            if (name.length() > biggestName.length())
            {
                biggestName=name;
            }
            name=sc.nextLine();
        }
        System.out.println("Longest name is "+biggestName);

    }
}