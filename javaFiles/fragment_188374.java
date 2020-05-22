ArrayList<String> list = new ArrayList<String>();
list.add("one");
list.add("two");
list.add("three");

String listString = "";
StringBuilder sb = new StringBuilder(64);
for (String s : list) {
    sb.append(s).append(", ");
}
listString = sb.delete(sb.length() - 2, sb.length()).toString();
System.out.println(listString);