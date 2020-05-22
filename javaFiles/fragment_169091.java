String string = "thisisastring";
StringBuffer buffer = new StringBuffer();
LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();

for(int i=0; i< string.length(); i++)
{
  char curChar = string.charAt(i);
  linkedHashMap.put(curChar, linkedHashMap.containsKey(curChar)?linkedHashMap.get(curChar)+1:1);
}

for(Map.Entry<Character, Integer> entry : linkedHashMap.entrySet())
  if(entry.getValue()%2 !=0)
    buffer.append(entry.getKey());

System.out.println(buffer.toString());  // prints hisarng