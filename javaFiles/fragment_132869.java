HashMap<String, Integer> hm = new HashMap<String, Integer>();
for (Entry<String, Integer> entry : hm.entrySet())
{
    String key = entry.getKey();
    if(key.equals("0") || key.equals("1"))
    System.out.println(key + "/" + entry.getValue());
}