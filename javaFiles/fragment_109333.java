package com.example;

    import org.quartz.Job;
    import org.quartz.JobExecutionContext;
    import org.quartz.JobExecutionException;

    public class ExampleJob implements Job
    {
        public void execute(JobExecutionContext context) throws JobExecutionException {
                // Code to make POST call here
    }