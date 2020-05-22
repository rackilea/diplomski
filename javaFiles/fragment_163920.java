import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.List;

public class LambdaTest     
{
    public static void main (String[] args)
    {
        List<String> objList = Arrays.asList("1", "2", "3", "4", "5", "6", "7");
        List<String> result = IntStream.range(0, objList.size())
            .filter( i -> (i % 2) == 0)
            .mapToObj(i -> (i<objList.size()-1)?(objList.get(i) + " " + objList.get(i + 1)):objList.get(i))
            .collect(Collectors.toList());      
        result.forEach(i -> System.out.print("\"" + i + "\" "));
    } 
}