public Node createNode(List<String> seq, Integer start)
{
    if (start >= seq.Length) {
        return null;
    }
    Node node = new Node();
    node.name = seq[start];
    node.children.Add(createNode(seq, start+1);

    return node;
}