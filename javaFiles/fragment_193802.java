import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class JBossAS7LikeFormatter extends SimpleFormatter
{
    private final String nl = System.getProperty("line.separator");
    private final DateFormat df = new SimpleDateFormat("HH:mm:ss,SSS");

    @Override
    public synchronized String format(LogRecord lr)
    {
        StringBuffer sb = new StringBuffer();

        // time only
        Date dt = new Date();
        dt.setTime(lr.getMillis());

        sb.append(df.format(dt));
        sb.append(" ");

        // level (longest is "WARNING" = 7 chars, space fill for level output)
        String level = lr.getLevel().getName();

        int numSpaces = 7 - level.length();

        sb.append(level);

        for ( int i = 0 ; i < numSpaces + 1 ; i++ )
        {
            sb.append(" ");
        }

        // package
        sb.append("[");
        sb.append(lr.getSourceClassName());
        sb.append("] ");

        // thread (name?)
        sb.append("(");
        sb.append(lr.getThreadID());
        sb.append(") ");

        // message
        sb.append(formatMessage(lr));
        sb.append(nl);

        // optional stack trace
        if ( lr.getThrown() != null )
        {
            try
            {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                lr.getThrown().printStackTrace(pw);
                pw.close();
                sb.append(sw.toString());
            }
            catch ( Exception e )
            {
            }
        }

        return sb.toString();
    }

}