2011-08-18 00:40:26,155 INFO [org.springframework.batch.core.launch.support.SimpleJobLauncher] - <Job: [FlowJob: [name=job1]] completed with the following parameters: [{run.id=1}] and the following status: [COMPLETED]>
2011-08-18 00:40:30,002 INFO [com.beny23.test.JobLauncherDetails] - <Quartz trigger firing with Spring Batch jobName=job1>
2011-08-18 00:40:30,015 ERROR [com.beny23.test.JobLauncherDetails] - <Could not execute job.>
org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException: A job instance already exists and is complete for parameters={run.id=1}.  If you want to run this job again, change the parameters.
    at org.springframework.batch.core.repository.support.SimpleJobRepository.createJobExecution(SimpleJobRepository.java:122)
    at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:39)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25)
    at java.lang.reflect.Method.invoke(Method.java:597)