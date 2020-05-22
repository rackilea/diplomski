import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

final public class Main
{
    public static void main(String...args)
    {
        String string, sub;
        ArrayList<String>al=new ArrayList<String>();

        int i, c, length;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string to print it's all unique substrings:->");
        string  = in.nextLine();

        length = string.length();

        System.out.print("Substrings of \""+string+"\" are :->");

        for(c=0;c<length;c++)
        {
            for(i=1;i<=length-c;i++)
            {
                sub = string.substring(c,c+i);
                al.add(sub);
            }
        }

        HashSet hs = new HashSet();
        hs.addAll(al);
        al.clear();
        al.addAll(hs);

        for(String str:al)
        {
            System.out.println(str);
        }
    }
}