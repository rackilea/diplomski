TreeSet<String> set = new TreeSet<String>();
set.add("jon");
set.add("david");
set.add("davis");
set.add("jonson");
set.add("henry");

Set<String> subset = set.tailSet("jon");
int count = 0;
for (String s : subset) {
    if (s.startsWith("jon")) count++;
    else break;
}
System.out.println("count = " + count);