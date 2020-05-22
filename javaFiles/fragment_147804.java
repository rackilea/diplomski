public class SearchStack<E> extends Object
{

public static void main(String[] args)
{
    SearchStack<String> ss = new SearchStack<String>();

    Stack<String> stack = new Stack<String>();

    for (int i = 0; i < 5; i++)
    {

        stack.push("a" + i);
    }

    System.out.println(stack.toString());

    System.out.println(ss.searchingStacks(stack, "a3"));
}
...
}