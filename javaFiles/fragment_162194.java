for (Iterator<Map.Entry<String, Node>> it = map.entrySet().iterator(); 
     it.hasNext();)
{
    Map.Entry<String, Node> entry = it.next();
    Node n = entry.getValue().optimize();
    if(n == null) 
    {
        it.remove();
    }
    else
    {
        entry.setValue(n);
    }
}