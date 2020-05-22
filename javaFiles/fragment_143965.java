static final Map<SortKey,Comparator<Issue>> ORDER;
static {
    Map<SortKey,Comparator<Issue>> m = new HashMap<>();
    Comparator<Issue> c = Comparator.comparing(Issue::getTitle);
    m.put(SortKey.of("Title", Direction.ASCENDING), c);
    m.put(SortKey.of("Title", Direction.DESCENDING), c.reversed());
    c = Comparator.comparing(Issue::getIssueElement);
    m.put(SortKey.of("IssueElement", Direction.ASCENDING), c);
    m.put(SortKey.of("IssueElement", Direction.DESCENDING), c.reversed());
    c = Comparator.comparing(Issue::getIssueType);
    m.put(SortKey.of("IssueType", Direction.ASCENDING), c);
    m.put(SortKey.of("IssueElement", Direction.DESCENDING), c.reversed());
    ORDER = Collections.unmodifiableMap(m);
}
private List<Issue> sortList(List<Issue> list, ISort... order) {
    if(order.length == 0) return new ArrayList<>(list);
    Comparator<Issue> cmp = ORDER.get(SortKey.of(order[0]));
    if(cmp == null) throw new IllegalArgumentException(order[0].toString());
    for(int ix = 1; ix < order.length; ix++) {
        Comparator<Issue> next = ORDER.get(SortKey.of(order[ix]));
        if(next == null) throw new IllegalArgumentException(order[ix].toString());
        cmp = cmp.thenComparing(next);
    }
    return list.stream().sorted(cmp).collect(Collectors.toList());
}