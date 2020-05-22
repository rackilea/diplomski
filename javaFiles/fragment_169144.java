final List<String> s1 = Arrays.asList(new String[]{"A", "B", "C"});
final List<String> s2 = Arrays.asList(new String[]{"D", "E", "F"});
final List<String> s3 = Arrays.asList(new String[]{"H", "I", "J"});
for (final String s : CombinedIterable.concat(s1, s2, s3)) {
    System.out.println(s);
}