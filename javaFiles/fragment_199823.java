@Override
public boolean equals(Object object)
{ 
    if(object instanceof Node)
    {
        Node node = (Node) object;
        if(source.equals(node.getSource() && target.equals(node.getTarget()))
        {
            return true;
        }
    } else {
        return false;
    }
}