import java.util.logging.Filter;
import java.util.logging.LogRecord;


public class PasswordFilter implements Filter {

    @Override
    public boolean isLoggable(LogRecord record) {
        if (isPasswordCallSite(record)) {
           //return false; // omit log entry.
           //Or hide password.
           Object[] params = record.getParameters();
           if (params != null && params.length != 0) {
               params = params.clone();
               String data = String.valueOf(params[0]);

                //Write code to find and replace password.
               params[0] = data;
               record.setParameters(params);
           }
        }
        return true;
    }

    private boolean isPasswordCallSite(LogRecord r) {
        return "foo.bar.ClientRequest".equals(r.getSourceClassName())
                && "writeEntity".equals(r.getSourceMethodName());
    }
}