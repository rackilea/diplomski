List<String> list = new ArrayList<>();
for (int i = 0; i < 500; i++) {
    list.add("A");
}
String s2 = list.parallelStream().reduce("x", String::concat, String::concat);
System.out.println(s2);
if (s2.length() != list.size() * 2) {
    System.out.println("Bad s2 size");
}