public Tree(String rootData)
{
    root=new Node();
    root.data=rootData;
    root.children=new ArrayList<Node>();
}

public Tree() {
    super();
}