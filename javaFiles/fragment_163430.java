import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Launcher 
{
    public static void main(String[] args) 
    {
        doThis();
        doThat();
    }

    private static void doThis()
    {
        System.out.println("dothis");
        try
        {
            List<String> myList1 = new ArrayList<String>();
            Collections.addAll(myList1, "str1","str2","str3","str4","str5");
            for(String element : myList1){//no ConcurrentModificationException here
            if(element.equalsIgnoreCase("str4"))
                myList1.remove("str4");
            }
            System.out.println(myList1);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void doThat()
    {
        System.out.println("dothat");
        try
        {
            List<String> myList2 = new ArrayList<String>();
            Collections.addAll(myList2, "str1","str2","str3","str4","str5");
            for(String element : myList2){//ConcurrentModificationException here
            if(element.equalsIgnoreCase("str1"))
                myList2.remove("str1");
            }
            System.out.println(myList2);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}