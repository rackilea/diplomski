import java.util.*;

public class Test
{
    public static void main(String[] args)
    {
        Stack<String> stack = new Stack<String>();
        stack.push("Bottom");
        stack.push("Middle");
        stack.push("Top");

        List<String> list = new ArrayList<String>(stack);

        for (String x : list)
        {
            System.out.println(x);
        }
    }
}