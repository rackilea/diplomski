public class myApplication extends WebApplication { 
    ...
    @Override
    public RequestCycle newRequestCycle(Request request, Response response) {
        return new myRequestCycle(this, (WebRequest) request, (WebResponse) response);
    }
} 

public class myRequestCycle extends WebRequestCycle { 
    ...
    @Override
    protected void logRuntimeException(RuntimeException rex) {
        super.logRuntimeException(rex);
        Writer w = new StringWriter();
        t.printStackTrace(new PrintWriter(w));
        String stackTrace = w.toString();
        someService.logExceptionToDB(rex.getMessage(),stackTrace);
    } 
}