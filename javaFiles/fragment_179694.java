//in run()
myNode = new Node();
myNode.name = "Root";
createNode(objects.get(0), 0, myNode, myNode);



public void createNode(List<String> seq, Integer start, Node parentNode)
{
    Node childNode = new Node();
    childNode.name = seq[start];
    parentNode.children.Add(childNode);
    createNode(seq, start+1, childNode);
}