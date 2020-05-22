import java.util.*;
public class Calc
{
    public static String itemList;
    public static String str;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        delimitThis();
        sc.close();
    }
    public static void delimitThis()// Delimiter to treat variable and numbers as seperate
    {
        List<String> items = Arrays.asList(str.split("\\s+"));
        System.out.println(items);

        for (int i = 0; i < items.size(); i++)
        {
            itemList = items.get(i);
            category();
        }
    }
    public static void category()////For Filtering between vars and constants and functions
    {
        for (int x = 0; x < itemList.length(); x++)
        {
            System.out.println(itemList.charAt(x));
        }

        // is 2 digit number or not?
        if(itemList.matches("\\d\\d+")){
            System.out.println(itemList + " is a two or more digit number");
        }else{
            System.out.println(itemList + " is NOT a two or more digit number");
        }
    }
}