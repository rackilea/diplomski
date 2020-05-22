class Node
{
    int k;
    int j;
}

public class AssignAndUseTestComplex
{
    public static void main(String[] args)
    {
        AssignAndUseTestComplex t = new AssignAndUseTestComplex();
        t.testSeparate(1);
        t.testInlined(1);
        t.testRepeated(1);
    }

    private Node table[] = new Node[] { new Node() };

    int testSeparate(int value)
    {
        Node[] tab = table;
        if (tab != null)
        {
            int n = tab.length;
            if (n > 0)
            {
                Node first = tab[(n-1)];
                if (first != null)
                {
                    return first.k+first.j;
                }
            }
        } 
        return 0;
    }

    int testInlined(int value)
    {
        Node[] tab; Node first, e; int n;
        if ((tab = table) != null && (n = tab.length) > 0 && 
            (first = tab[(n - 1)]) != null) {
            return first.k+first.j;
        }
        return 0;
    }

    int testRepeated(int value)
    {
        if (table != null)
        {
            if (table.length > 0)
            {
                if (table[(table.length-1)] != null)
                {
                    return table[(table.length-1)].k+table[(table.length-1)].j;
                }
            }
        } 
        return 0;
    }

}