for (Iterator<Map.Entry<Key,Value>> it = map.entrySet().iterator(); it.hasNext();)
{
    Map.Entry<Key,Value> entry = it.next();
    // process the entry
    if(need to delete the entry) 
    {
        it.remove();
    }
}