Map<String, List<String>> map = new HashMap<String, List<String>>()

Pseudocode:

for (List<String> line : file1.lines) {
 List curLine = new LinkedList();
 curLine.add(line.get(0));
 curLine.add(line.get(1));

 map.put(line.get(2),curLine)
}

for (List<String> line : file2.lines) {
 String key = line.get(0);
 String list = map.get(key);
 if (list != null)
 {
  list.add(line.get(1));
  list.add(line.get(2));
 }

 map.put(key,list); // probably not necessary as you change the reference that is already in the map, but I'm not sure

}