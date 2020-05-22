private List<Issue> sortList(List<Issue> list, String field, String sort) {
    Comparator<Issue> cmp;
    switch(field) {
        case "Title": cmp = Comparator.comparing(Issue::getTitle); break;
        case "IssueElement": cmp = Comparator.comparing(Issue::getIssueElement); break;
        case "IssueType": cmp = Comparator.comparing(Issue::getIssueType); break;
        default: throw new IllegalArgumentException("unknown property '"+field+"'");
    }
    if("DESC".equalsIgnoreCase(sort)) cmp = cmp.reversed();
    else if(!"ASC".equalsIgnoreCase(sort))
        throw new IllegalArgumentException("invalid sort '"+sort+"'");
    return list.stream().sorted(cmp).collect(Collectors.toList());
}