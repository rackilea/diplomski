public class TestLog4j {

static Logger log = Logger.getLogger(TestLog4j.class.getName());

int id;
ArrayList<String> errors,fatals;

public void addError(String e)
{

    this.errors.add(e);
}
public void addFatal(String f)
{

    this.fatals.add(f);
}

public void sendLogs() {

    SimpleDateFormat sdf = new SimpleDateFormat();

    for (String e : this.errors)
    {
         log.error("Error Message at "+sdf.format(new Date()) + " for id "+ this.id);
    }
    for (String f : this.fatals)
    {
          log.fatal("Fatal Message at "+sdf.format(new Date()) + " for id "+ this.id);
    }


    }

}