List<String> l = new ArrayList<>();
l.add("Hello world");
l.add("StackOverflow is awesome");

String[][] s = new String[l.size()][];

for (int i=0; i<l.size(); i++) {
  String[] words = l.get(i).split(" ");
  s[i] = words;
}

for (int i=0; i<s.length; i++) {
  for (int j=0; j<s[i].length; j++) {
    System.out.print(s[i][j] + " ");
  }
  System.out.println();
}