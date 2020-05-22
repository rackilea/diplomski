class LogExportingProcess extends Thread 
{
    private HttpSession session;

    public LogExportingProcess(HttpSession session) {
       this.session = session;
    }

    public void run()
    {
        session.setAttribute("CompletionStatus" , completePercent);
    }   
}