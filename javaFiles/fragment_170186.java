package dev.dit.scheduler;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job {

  final static Logger logger = Logger.getLogger(TestJob.class);

  @Override
  public void execute(JobExecutionContext context) throws JobExecutionException {

    logger.info("Job executed!"); 
  }
}