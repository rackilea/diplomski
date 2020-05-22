public class MyUploader extends AuUploader {
    @Override
    protected String handleError(Throwable ex)
    {
        return "mymessage";
    }        
}