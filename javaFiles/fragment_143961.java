// in Java 9, you should replace Arrays.asList(...) with List.of(...)
static final Map<List<String>,Comparator<Issue>> ORDER;
static {
    Map<List<String>,Comparator<Issue>> m = new HashMap<>();
    Comparator<Issue> c = Comparator.comparing(Issue::getTitle);
    m.put(Arrays.asList("Title", "asc"), c);
    m.put(Arrays.asList("Title", "desc"), c.reversed());
    c = Comparator.comparing(Issue::getIssueElement);
    m.put(Arrays.asList("IssueElement", "asc"), c);
    m.put(Arrays.asList("IssueElement", "desc"), c.reversed());
    c = Comparator.comparing(Issue::getIssueType);
    m.put(Arrays.asList("IssueType", "asc"), c);
    m.put(Arrays.asList("IssueType", "desc"), c.reversed());
    ORDER = Collections.unmodifiableMap(m);
}
private List<Issue> sortList(List<Issue> list, String field, String sort) {
    Comparator<Issue> cmp = ORDER.get(Arrays.asList(field, sort.toLowerCase(Locale.ROOT)));
    if(cmp == null)
        throw new IllegalArgumentException("property '"+field+"', sort '"+sort+"'");
    return list.stream().sorted(cmp).collect(Collectors.toList());
}