import java.util.*;
public class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        StringBuilder str = new StringBuilder(s);
        n1--;/*as string is "Zero" index based*/
        n2--;
        /*changing character as n1 position*/
        if(Character.isUpperCase(s.charAt(n1)))  //return true if UpperCase
            str.setCharAt(n1,Character.toLowerCase(s.charAt(n1)));
        else
            str.setCharAt(n1,Character.toUpperCase(s.charAt(n1)));
        /*changing character as n2 position*/
        if(Character.isUpperCase(s.charAt(n1)))  //return true if UpperCase
            str.setCharAt(n2,Character.toLowerCase(s.charAt(n2)));
        else
            str.setCharAt(n2,Character.toUpperCase(s.charAt(n2)));
        System.out.println(str);
    }
}