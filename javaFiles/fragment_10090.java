List<String> list = new ArrayList<>();
HashSet<String> strings = new HashSet<>(Arrays.asList(a2));
for (String s : a1) { 
   if (strings.contains(s)) list.add(s); 
}
String[] result = list.toArray(new String[0]);