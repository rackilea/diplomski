String str = ...
str = str.substring(1, str.length() - 1);     // removing the {}
String[] entries = str.split(",");            // get all the "key":value
for (String entry: entries) {
   String[] entryData = entry.split(":");     // get the key and the value
   String key = entryData[0];
   key = key.substring(1, key.length() - 1);  // removing the "" from key
   String value = entryData[1];
   System.out.println(key + " -> " + value);
}