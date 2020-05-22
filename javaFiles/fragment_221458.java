import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main
{
    static List<String> names;    
    static List<String> colors= Arrays.asList("red","green");

    static // notice that this method has no name!
    {
        names=new ArrayList<String>();
        names.add("CuriousIndeed");
        names.add("Stefan");
    }

    public static void main(String[] args)
    {
        System.out.println(names);
        System.out.println(colors);
    }
}