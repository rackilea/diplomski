for (JiraFixVersion jiraFixVersion : listJiraFixVersionsProject) {

        Iterator<Issue> issues = JiraClientManager.getInstance().getSearchResultSet("project='" + jiraProject.getProjectName() + "' AND fixVersion =" + "'" + jiraFixVersion.getName() + "'" + " AND cf[10002] !=null").iterator();
        Double sumStoryPoints = 0.0;
        while (issues.hasNext()) {
            Issue issue = issues.next();
            String storyPoints = issue.getField("customfield_10002").getValue().toString();
            Double storyPointIssue = Double.parseDouble(storyPoints);
            sumStoryPoints += storyPointIssue;
        }
        returnMap.put(jiraFixVersion, sumStoryPoints);
    }