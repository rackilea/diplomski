public static Node naireTreeToBinaryTree (Node node,Document d)
{
    if (isLeaf(node))
    {
        //-return node;            
        return d.createElement(node.getNodeName());
    }
    else 
    {
        List<Element> liste = getChildren(node);
        Node tmp= d.createElement(node.getNodeName());          
        for (int i=0;i<liste.size();i++)
        {
            Element root = d.createElement("DIESE");
            root.appendChild(tmp);

            //-Element child2 = d.createElement(naireTreeToBinaryTree(liste.get(i),d).getNodeName());
            Node child2 = naireTreeToBinaryTree(liste.get(i),d);
            root.appendChild(child2);
            tmp=root;

        }
      return tmp;
    }
}