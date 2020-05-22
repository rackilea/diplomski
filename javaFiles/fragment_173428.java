@Override
public void execute(JobExecutionContext context)
        throws JobExecutionException {
    Context ctx = null;
    try {
        ctx = new InitialContext();
        IJobContent exampleBean = (IJobContent) ctx
                .lookup("java:global/DSMonitor/jobcontent!de.bva.dsmonitor.job.IJobContent");
        exampleBean.doStuff();

    } catch (NamingException e) {
        System.err.println("EJB JobContent not found!");
        e.printStackTrace();
    }

}