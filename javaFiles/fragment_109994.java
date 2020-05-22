import java.util.function.*;
public class Test
{
    static Function<Integer, Integer> fib = null;

    public static void main (String[] args)
    {      
        fib = n ->
              n == 0 ? 0
              : n == 1 ? 1
              : fib.apply(n - 1) + fib.apply(n - 2); 
        System.out.println(fib.apply(8));
    }

}