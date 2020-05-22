public class TriggerJob {

                String jobStatus = "";
                SchedulerMetaData metaData = null;

                public String schedule_rightNow(HashMap ParamMap){  

                    try{
                        SchedulerFactory sf = new StdSchedulerFactory();
                        Scheduler sch = sf.getScheduler();
                        String txtjob=ParamMap.get("txtJobName").toString();
                        JobKey jobKey = new JobKey(txtjob, "Group1");
                        JobDetail job = newJob(JobSchedule.class).withIdentity(jobKey)
                                .build();
                        long timestamp=System.currentTimeMillis();
                        String sTimeStamp = String.valueOf(timestamp);
                        SimpleTrigger trigger = newTrigger().withIdentity(sTimeStamp, "Group1")
                                .startNow().
                                withSchedule(simpleSchedule()
                                        .withIntervalInSeconds(1).withMisfireHandlingInstructionFireNow())
                                        .build();
                        sch.getListenerManager().addJobListener(new ListernerTrigger(), KeyMatcher.keyEquals(jobKey));
                        job.getJobDataMap().putAll(ParamMap);
                        Date ft  = sch.scheduleJob(job,trigger);


                        sch.start();
                        Thread.sleep(5L * 1000L);
                        sch.shutdown(true);
                        metaData = sch.getMetaData();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    return jobStatus;
                }
            }