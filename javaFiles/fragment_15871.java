Map<String, Integer> cout = new HashMap<String, Integer>();

for (String line : StringArray) {
  for (String s : line.split("-")) {
     Integer currentCount = counts.get(s);
     if (currentCount == null)
       counts.put(s, 1);
     else
       counts.put(s, currentCount + 1);
  }
}
//Look in currentCount all keys with a value larger than 1.