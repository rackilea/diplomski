Dictionary<String, String> dict = new Hashtable<>();
dict.put("1", "Aniruddha");
dict.put("2", "Anir");
dict.put("3", "Anirdha");
dict.put("4", "Anuddha");

Enumeration<String> keys = dict.keys();
while (keys.hasMoreElements()) {
    String theRealKey = keys.nextElement();
    dict.remove(theRealKey);
}

dict.put("5", "swew");
System.out.println(dict.get("5"));