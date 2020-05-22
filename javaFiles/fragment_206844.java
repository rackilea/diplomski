Set<Issue> issues = EnumSet.noneOf(Issue.class);
if( not scheduled ) {
    issues.add(Issue.NOT_SCHEDULED);
}
if( too late ) {
    issues.add(Issue.TOO_LATE);
}
return issues;