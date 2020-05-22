@SuppressWarnings("unchecked")
private Object fixLongs(Object p)
{
    String t = p.getClass().getName();
    if (t == "java.util.Map" || t == "java.util.HashMap" || t == "org.json.simple.JSONObject")
    {
        HashMap<Object, Object> n = new HashMap<Object, Object>(((HashMap<Object, Object>) p).size());
        Iterator<Entry<Object, Object>> it = ((HashMap<Object, Object>) p).entrySet().iterator();
        while (it.hasNext())
        {
            Entry<Object, Object> e = it.next();
            n.put(this.fixLongs(e.getKey()), this.fixLongs(e.getValue()));
        }
        return n;
    }
    else if (t == "java.lang.Long")
    {
        return new Integer(((Long) p).intValue());
    }
    else
    {
        return p;
    }
}