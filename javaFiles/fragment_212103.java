package com.testing.domain;

import java.util.List;

public class GeneralRequest {
    private String processTypeJob;
    private String waitTime;
    private List<String> processIds;
    private String processTypeGroup;
    private List<JobConfiguration> jobConfigurations;

    public String getProcessTypeJob() {
        return processTypeJob;
    }
    public void setProcessTypeJob(String processTypeJob) {
        this.processTypeJob = processTypeJob;
    }
    public List<String> getProcessIds() {
        return processIds;
    }
    public void setProcessIds(List<String> processIds) {
        this.processIds = processIds;
    }
    public String getProcessTypeGroup() {
        return processTypeGroup;
    }
    public void setProcessTypeGroup(String processTypeGroup) {
        this.processTypeGroup = processTypeGroup;
    }
    public List<JobConfiguration> getJobConfigurations() {
        return jobConfigurations;
    }
    public void setJobConfigurations(List<JobConfiguration> jobConfigurations) {
        this.jobConfigurations = jobConfigurations;
    }
    public String getWaitTime() {
        return waitTime;
    }
    public void setWaitTime(String waitTime) {
        this.waitTime = waitTime;
    }



}