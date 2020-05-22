System.out.println("Initializing Scheduler PlugIn for Jobs!");
super.init(config);
ServletContext ctx = config.getServletContext();
Scheduler scheduler = null;
StdSchedulerFactory factory = (StdSchedulerFactory) 
ctx.getAttribute(QuartzInitializerServlet.QUARTZ_FACTORY_KEY);  

try {   
scheduler = factory.getScheduler();
JobDetail jd = new JobDetail("job1", "group1",ExcelJob.class);  
CronTrigger cronTrigger = new CronTrigger("trigger1","group1");
String cronExpr = null;
cronExpr = getInitParameter("cronExpr");
System.out.println(cronExpr);   
cronTrigger.setCronExpression(cronExpr);
scheduler.scheduleJob(jd, cronTrigger);
System.out.println("Job scheduled now ..");

} catch (Exception e){
e.printStackTrace();
}