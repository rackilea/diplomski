public class MyServletContextListener implements ServletContextListener{
  public void contextInitialized(ServletContextEvent event){
    ArrayList list = new ArrayList();

    //add to ServletContext
    event.getServletContext().setAttribute("list", list);

    JobDataMap map = new JobDataMap();
    map.put("list", list);
    JobDetail job = new JobDetail(..., MyJob.class);
    job.setJobDataMap(map);
    //execute job
  }

  public void contextDestroyed(ServletContextEvent event){}
}

//Quartz job
public class MyJob implements Job{
  public void execute(JobExecutionContext context){
    ArrayList list = (ArrayList)context.getMergedJobDataMap().get("list");
    //...
  }
}