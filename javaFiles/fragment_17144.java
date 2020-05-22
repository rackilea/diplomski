for (int i=0;i< issues.size();i++) {
    Issue iss = issues.get(i);
    // check if given project is already in map -> if not, add IssueStatus instance
    if (! issueStatusMap.contains(iss.Project)) {
        issueStatusMap.put(iss.Project, new IssueStatus());
    }
    // add issue status cound
    issueStatusMap.get(iss.Project).addStatusCount(iss.Status);
}