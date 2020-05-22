// now you only have to get the data simply

// 1) sum of issues
for(Map.Entry<String, IssueStatus> entry : issueStatusMap.entrySet()) {
    s.o.p("project name: " + entry.getKey() + " has " + entry.getValue().getTotalIssues());
}
// or use the sum of the three getNum... methods

// 2) count only closed + resolved
for(Map.Entry<String, IssueStatus> entry : issueStatusMap.entrySet()) {
    IssueStatus is = entry.getValue();
    s.o.p("project name: " + entry.getKey() + " status count: closed + resolved = " + (is.getNumOfClosed() + is.getNumOfResolved()));
}