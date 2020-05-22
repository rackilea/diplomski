//HashMap<String, ArrayList<String>> hashMap;  
//initialized somewhere above

HashMap<String, String> newHashMap = new HashMap<>();

for (Map.Entry<String, ArrayList<String>> entry : hashMap.entrySet())
{
    newHashMap.put(entry.getKey(), entry.getValue().toString());
}