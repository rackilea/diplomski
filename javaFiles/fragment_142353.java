public class Node
{
    public bool NullNode { get; set; }

    public Node[] Children { get; set; }

    public Node()
    {
        NullNode = false;
        Children = new Node[256];
    }
}