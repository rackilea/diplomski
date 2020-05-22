public class Node<E>
{
    private E data;

    public Node(E e)
    {
        this.data = e;
    }

    public E getData()
    {
        return data;
    }

    public void setData(E e)
    {
        data = e;
    }

    public void print()
    {
        System.out.println(data.toString());
    }
}

public class MyClass
{
    public void doSomething()
    {
        List<Node<Float>> listOfFloatNodes = new ArrayList<Node<Float>>();
        listOfFloatNodes.add(new Node<Float>(new Float(8.7472742f)));
        listOfFloatNodes.add(new Node<Float>(new Float(5.56842742f)));
        listOfFloatNodes.add(new Node<Float>(new Float(6.5467742f)));
        MyOtherClass moc = new MyOtherClass();
        moc.useNodeList(listOfFloatNodes);
    }
}

public class MyOtherClass
{
    public <E> void useNodeList(List<Node<E>> list)
    {
         for(Node<E> node : list)
         {
             printNode(node);
         }
    }

    public <E> void printNode(Node<E> node)
    {
         node.print();
    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        MyClass myClass = new MyClass();
        myClass.doSomething();
    }
}