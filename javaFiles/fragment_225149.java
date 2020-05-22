List<String> source = Arrays.asList("123-456789", "(1)23456789");
System.out.printf("Source List contains: %s%n", source);
Set<String> set = new HashSet<>();
List<String> unnecessary = new ArrayList<>();
Set<String> useful = new HashSet<>();

for (String s: source) {
    if (set.add(s)) System.out.printf("Added %s to set.%n", s);
    s = s.replaceAll("[()-]", "");
    System.out.printf("\t... now normalized to %s%n", s);
    // s is now normalized
    unnecessary.add(s);
    useful.add(s);
}
System.out.printf(
    "Set contains %s.%nUnnecessary List contains %s.%nUseful Set contains %s.%n", 
    set, 
    unnecessary,
    useful
);