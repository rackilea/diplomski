import java.util.Arrays;
import java.util.HashSet;

public class Main
{
    public static void main(String[] args) throws Exception
    {

        String[] links = {"a","b","a","c","b","c","d","e","f"};

        HashSet<String> set=new HashSet<>();
        set.addAll(Arrays.asList(links));

        System.out.println(set);
    }
}