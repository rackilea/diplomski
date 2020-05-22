String[][] children = new String[][] { child0, child1, child2, child3, /* ... */ };
for (int i = 0; i < children.length; i++) {
  String[] child = children[i];
  for (int j = 0; j < child.length(); j++) {
    Map<String, String> curChildMap = new HashMap<String, String>();
    children.add(curChildMap);
    curChildMap.put(NAME, child[j]);
    curChildMap.put(IS_EVEN, (j % 2 == 0) ? "This child is even" : "This child is odd");
  }   
}