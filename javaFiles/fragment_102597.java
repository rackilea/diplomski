import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberPuzzleWithCats
{
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(10,7,8,3,7);
        solve(numbers);
    }

    private static void solve(List<Integer> numbers)
    {
        List<Node> nodes = new ArrayList<Node>();
        for (int i=0; i<numbers.size(); i++)
        {
            Integer number = numbers.get(i);
            nodes.add(new Node(number));
        }
        System.out.println(nodes);
        List<Node> all = create(nodes);
        System.out.println("Found "+all.size()+" combinations");


        for (Node node : all)
        {
            String s = node.toString();
            System.out.print(s);
            if (s.equals("((10*7)-(8*(3+7)))"))
            {
                System.out.println(" <--- There is is :)");
            }
            else
            {
                System.out.println();
            }
        }
    }

    private static List<Node> create(Node n0, Node n1)
    {
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(new Node(n0, '+', n1));
        nodes.add(new Node(n0, '*', n1));
        nodes.add(new Node(n0, '-', n1));
        nodes.add(new Node(n0, '/', n1));
        nodes.add(new Node(n1, '+', n0));
        nodes.add(new Node(n1, '*', n0));
        nodes.add(new Node(n1, '-', n0));
        nodes.add(new Node(n1, '/', n0));
        return nodes;
    }

    private static List<Node> create(List<Node> nodes)
    {
        if (nodes.size() == 1)
        {
            return nodes;
        }
        if (nodes.size() == 2)
        {
            Node n0 = nodes.get(0);
            Node n1 = nodes.get(1);
            return create(n0, n1);
        }
        List<Node> nextNodes = new ArrayList<Node>();
        for (int i=1; i<nodes.size()-1; i++)
        {
            List<Node> s0 = create(nodes.subList(0, i));
            List<Node> s1 = create(nodes.subList(i, nodes.size()));
            for (Node n0 : s0)
            {
                for (Node n1 : s1)
                {
                    nextNodes.addAll(create(n0, n1));
                }
            }
        }
        return nextNodes;
    }

    static class Node
    {
        int value;
        Node left;
        Character op;
        Node right;

        Node(Node left, Character op, Node right)
        {
            this.left = left;
            this.op = op;
            this.right = right;
        }
        Node(Integer value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            if (op == null)
            {
                return String.valueOf(value);
            }
            return "("+left.toString()+op+right.toString()+")";
        }
    }
}