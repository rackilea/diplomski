StdSchedulerFactory schedFact = (StdSchedulerFactory)
  ctx.getAttribute("org.quartz.impl.StdSchedulerFactory.KEY");
try {
    Scheduler scheduler = schedFact.getScheduler("LenartScheduler");
    // schedule Jobs here...
} catch (SchedulerException e) {
    // properly handle the exception...
}