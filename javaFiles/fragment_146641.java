while (issues.hasNext()) {

            Issue issue = issues.next();
            try {
                Issue claim = JiraClientManager.getInstance().getRestClient().getIssueClient().getIssue(issue.getKey()).claim();
                TimeTracking timeTracking = claim.getTimeTracking();
                Integer estimatedTimeSeconds =(Integer) issue.getField("timeoriginalestimate").getValue();
                Double estimatedTimeHours = (estimatedTimeSeconds.doubleValue())/3600;
                System.out.println(estimatedTimeHours+" "+issue.getKey());
                sumEstimatedTimeHours += estimatedTimeHours;
            }catch(NullPointerException e){
                System.out.println("Time Tracking null "+ issue.getKey());
            }
        }