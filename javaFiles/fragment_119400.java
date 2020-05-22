public class SampleListener implements ServletContextListener {

public static final long _startTimerDelayMin = 10; // In minutes
public static final long _startTimerPeriodMin = 60; // In minutes

Timer timer;
ServletContext context =null;       

public void contextInitialized(ServletContextEvent contextEvent) {      
    context = contextEvent.getServletContext();     
    scheduleTimer();        
}   

public void scheduleTimer() {
    long delay = _startTimerDelayMin * 60000;   //initial delay set to _startTimerDelayMin minutes as per msecs
    long period = _startTimerPeriodMin * 60000;   //subsequent rate set to _startTimerPeriodMin minutes as per msecs
    timer = new Timer();
    timer.scheduleAtFixedRate(new RemindTask(), delay, period); 
}

public void contextDestroyed(ServletContextEvent arg0) {
    //Stopping Timer Thread once context destroyed
    timer.cancel();
}

private static String getPropertyValue(String key){
    String value = "";
    try{
        value = Util.getPropertyValueOfKey(key).trim();
    }catch(IOException e){

    }
    return value;
}

/**
 * This class is invoked at given interval to clear the application scope variable for browse call which have not been used for given time
 *
 */
class RemindTask extends TimerTask {

    public void run() {
        clearScopeVariables();
    } 

    /**
     * This function has logic to clear the application scope variable for browse call which have not been used for given time
     */
    public void clearScopeVariables() {
        Date dt = new Date();
        Enumeration<String> applicationScopeVarNames = (Enumeration<String>)context.getAttributeNames();
                    // TODO: clear the scope variables
    }       
}