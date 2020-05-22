import java.util.*;

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Collections.shuffle(numbers);
        System.out.println(numbers);
    }
}