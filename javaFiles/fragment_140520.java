package com.viremp.component;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HandleHobs {
private static Logger LOGGER = LoggerFactory.getLogger(HandleHobs.class);

private static JobDetail job;

private static Scheduler scheduler;
String email;

// SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();

public HandleHobs(String email) {
    this.email = email;
}

private static Trigger trigger;

{
    try {

        LOGGER.info("initializing job");

        job = (JobDetail) newJob(JobStoredScreenShot.class).withIdentity("job1", "group1").build();

        trigger = newTrigger().withIdentity("trigger1", "group1").startNow()
                .withSchedule(simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();

        scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(job, trigger);
        LOGGER.info("init successsful 1");
    } catch (Exception e) {
        LOGGER.error("fail to init variables for job", e);
    }
}

public HandleHobs() {

}

public void startJobStoredScreenShot(String email) {
    try {
        System.out.println("yaar ma aa gaya hun");
        this.email = email;
        JobStoredScreenShot jss = new JobStoredScreenShot();
        jss.setEmail(email);
        if (scheduler != null && !scheduler.isStarted()) {

            Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
            System.out.println("here..... " + email);
            scheduler1.getContext().put("email", email);
            System.out.println("and here..... " + email);
            scheduler.start();

        }
        LOGGER.info("init successsful");
    } catch (Exception e) {
        LOGGER.error("fail to init job JobStoredScreenShot", e);
    }
}

public void shutdownJobStoredScreenShot() {
    try {
        if (scheduler.isStarted()) {
            // JobExecutionContext context = new JobExecutionContext();
            // JobKey key = context.getJobDetail().getKey();
            // String jobId = key.getName();
            // System.out.println("```````````````````NAME``````````````````````" + jobId);
            // flag = true;

            scheduler.shutdown();
            scheduler = null;  //i made it null here
            job = null; // i made it null here
        }
        LOGGER.info("shutdown successsful");
    } catch (Exception e) {
        LOGGER.error("fail to init job JobStoredScreenShot", e);
    }
}

public boolean isJobStoredScreenShotIsStarted() {
    boolean isStarted = false;
    try {

        if (scheduler != null) {
            isStarted = true;
        }
    } catch (Exception e) {
        LOGGER.error("fail get isTarted", e);
    }
    return isStarted;
}

}