import java.util.*;
public class Help
{
    public static void main(String[] args)
    {
        Scanner scan1 = new Scanner(System.in);
      String str = "";

      System.out.println("Input an abbreviation: ");
     str = scan1.nextLine();
      ChangeCh(str);



    }
    private static void ChangeCh(String str) 
    {
        StringBuilder sb = new StringBuilder("");
     for(int x=0;x<str.length();++x)
     {
         if(Character.isLowerCase(str.charAt(x)))
             sb.append(Character.toUpperCase(str.charAt(x)));
         else if(Character.isUpperCase(str.charAt(x)))
               sb.append(Character.toLowerCase(str.charAt(x)));

     }
     System.out.println(sb.toString());
    }

}