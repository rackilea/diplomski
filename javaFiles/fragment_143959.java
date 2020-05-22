private List<Issue> sortList(List<Issue> list, String field, String sort) {
    Function<Issue,String> f;
    switch(field) {
        case "Title": f = Issue::getTitle; break;
        case "IssueElement": f = i -> i.getIssueElement().toString(); break;
        case "IssueType": f = i -> i.getIssueType().toString(); break;
        default: throw new IllegalArgumentException("unknown property '"+field+"'");
    }
    Comparator<Issue> cmp = Comparator.comparing(f);
    if("DESC".equalsIgnoreCase(sort)) cmp = cmp.reversed();
    else if(!"ASC".equalsIgnoreCase(sort))
        throw new IllegalArgumentException("invalid sort '"+sort+"'");
    return list.stream().sorted(cmp).collect(Collectors.toList());
}