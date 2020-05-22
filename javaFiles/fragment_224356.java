import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

public class MyPatternLayout extends PatternLayout
{
  @Override
  public String format(LoggingEvent event)
  {
    String msg = super.format(event);
    msg = msg.replace("com.mycompany.projectname", "");

    return msg;
  }
}