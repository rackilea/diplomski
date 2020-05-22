String[] departments = new String[] { "Junior Managment", "Middle Management", "Senior Management", "Top Management" };
String[] tests = new String[] { "management", "age", "junior", "mid", "op management", "uni middle", "junior middle management" };
for (String searchString : tests) {
    List<String> searchWords = new ArrayList<>(Arrays.asList(searchString.split(" ")));
    searchWords.replaceAll(String::toLowerCase);
    searchWords.removeIf("management"::contains);
    Set<String> matches = new HashSet<>(departments.length);
    matches.addAll(Stream.of(departments)
            .filter(d -> searchWords.stream().anyMatch(d.toLowerCase()::contains))
            .collect(Collectors.toSet()));

    System.out.println(searchString + ": " + matches);
}