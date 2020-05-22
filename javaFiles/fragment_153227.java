public JobKey findJobKey(String jobName) {
    // Check running jobs first
    for (JobExecutionContext runningJob : scheduler.getCurrentlyExecutingJobs()) {
        if (Objects.equals(jobName, runningJob.getJobDetail().getKey().getName())) {
            return runningJob.getJobDetail().getKey();
        }
    }
    // Check all jobs if not found
    for (String groupName : scheduler.getJobGroupNames()) {
        for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
            if (Objects.equals(jobName, jobKey.getName())) {
                return jobKey;
            }
        }
    }
}