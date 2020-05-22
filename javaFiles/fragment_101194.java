List<String> list = new ArrayList<String>();
list.add("a1");
list.add("a2");
list.add("a3");
for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
    String string =  iterator.next();
    System.out.println(string);
}