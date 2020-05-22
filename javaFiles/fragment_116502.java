Map<String,String> strMap = new Map<String,String>();
// now put your strings into strMap like
map.put("your_key", "yourValue");
to retrieve the value corresponding to Key it will be like:
if(strMap.containsKey(str)){// your str
return strMap.get(str);
}