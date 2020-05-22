import java.io.*;
import java.util.*;
class Test
{
public static void main(String args[])throws IOException
{

   List<Integer> I = new ArrayList<Integer>();
    String[] s = {"Light", "Sun", "Sun", "Water"}; 
    String[] ss = {"on", "off", "on", "off"};
    for(int i = 0; i < s.length; i++) { 
        switch (s[i]) { 
            case "Light": 
            if (ss[i]=="on") 
            I.add(1); 
            else 
            I.add(2);
            break;
            case "Sun": 
            if (ss[i]=="on") 
            I.add(3); 
            else 
            I.add(4);
            break; 
            case "Water": 
            if (ss[i]=="on") 
            I.add(5); 
            else 
            I.add(6);
            break;
            case "Gravel": 
            if (ss[i]=="on") 
            I.add(7); 
            else 
            I.add(8); 
            break;
            } 
            System.out.println(I+" at i="+i);
        } 
    Integer[] arr = I.toArray(new Integer[I.size()]);
    System.out.println(I);
}
}