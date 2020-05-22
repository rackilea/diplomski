Map<Character,Integer> digCount = Files
    .lines(Paths.get("/path/to/file/text.txt"))
    .filter(Pattern.compile("\\d+").asPredicate())
    .collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.summingInt(s->1)));
for (Map.Entry<Character,Integer> e : digCount.entrySet()) {
    System.out.println(e.getKey()+" "+e.getValue());
}