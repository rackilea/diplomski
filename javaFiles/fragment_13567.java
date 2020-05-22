import java.util.*;

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        List<String> roles = Arrays.asList("M", "M", "A", "D", "C", "C");
        Collections.shuffle(roles);
        System.out.println(roles);
    }
}