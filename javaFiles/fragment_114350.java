public Node createNode(List<String> seq, Integer start)
{
    if (start >= seq.size())
        return null;

    Node node = new Node();
    node.name = seq.get(start);
    node.children.add(createNode(seq, start+1));

    return node;
}