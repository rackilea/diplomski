private List<Map<String,String>> mapReduce(AggregationOutput output){
    List<Map<String,String>> out = new ArrayList<Map<String, String>>();
    for (DBObject result : output.results()) {
        Map<String,String> map = ConvertDBObjectToMap(result, "");
        out.add(map);
    }
    return out;
}


private Map<String,String> ConvertDBObjectToMap(DBObject result, String parent)
{
    String prefix = parent == "" ? "" : parent + "_";

    Map<String,String> out = new HashMap<String, String>();
    String[] keys = result.keySet().toArray(new String[result.keySet().size()]);
    for(String key : keys)
    {
        Object obj = result.get(key);
        if(obj instanceof BasicDBObject)
        {
            out.putAll(ConvertDBObjectToMap((BasicDBObject) obj, prefix + key));
        }
        else if(obj instanceof String)
        {
            out.put(prefix + key,(String)obj);
        }
        else if(obj instanceof  Date){
            out.put(prefix + key,obj.toString());
        }
        else{
            out.put(prefix + key,obj.toString());
        }
    }
    return out;
}