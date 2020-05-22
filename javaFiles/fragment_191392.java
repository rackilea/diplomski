LinkedList<String> list = new LinkedList<>(Arrays.asList("p", "r", "r", "q", "p", "p", "r"));

String prev = null;
String curr = null;
String next = "-";
for (String value : list) {
    prev = curr;
    curr = next;
    next = value;
    if (prev != null)
        System.out.println(curr + prev + next);
}
prev = curr;
curr = next;
next = "-";
System.out.println(curr + prev + next);