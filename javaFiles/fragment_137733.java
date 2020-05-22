public void getAllChildren(ArrayList<Node> list, Node parentNode)
{
    NodeList childList = parentNode.getChildNodes()
    for(Node node : childList)
    {
       list.add(node);
       getAllChildren(list, node);
    }
}