List<String> list = new ArrayList<String>();
list.add("a1");
list.add("a2");
list.add("a3");
String string = null;
for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); string = iterator.next()) {
    System.out.println(string);
}