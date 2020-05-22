public Map<String, List<Issue>> mapComponentToIssueList(List<Issue> issues) {
    Map<String, List<Issue>> map = new HashMap<String, List<Issue>>();

    for (Issue issue : issues) {
        String componentName = issue.getComponents().iterator().next().getString("name");
        List<Issue> list = map.get(componentName);
        if (list == null) {
            list = new ArrayList<Issue>();
            map.put(componentName, list);
        }
        list.add(issue);
    }
    return map;
}