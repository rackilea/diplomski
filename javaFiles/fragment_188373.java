ArrayList<String> list = new ArrayList<String>();
list.add("one");
list.add("two");
list.add("three");

String listString = "";
StringJoiner sj = new StringJoiner(", ");
for (String s : list) {
    sj.add(s);
}
listString = sj.toString();
System.out.println(listString);