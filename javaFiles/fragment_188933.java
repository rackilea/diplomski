Map<String, String> m = new HashMap<String, String>();
for (String s : stuff.split("\\^\\^"))  // caret needs escaping
{  
    String[] kv = s.split("=");
    m.put(kv[0]) = kv[1];
}