ApplicationContext context = new ClassPathXmlApplicationContext("path/to/applicationContext.xml");

JobLauncher launcher=(JobLauncher)context.getBean("launcher");
Job job=(Job)context.getBean("job");

//Get as many beans you want
//Now do the thing you were doing inside test method
StopWatch sw = new StopWatch();
sw.start();
launcher.run(job, jobParameters);
sw.stop();
//initialize the log same way inside main
logger.info(">>> TIME ELAPSED:" + sw.prettyPrint());