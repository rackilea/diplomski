@Component
public class StartupHousekeeper implements ApplicationListener<ContextRefreshedEvent> {

  @Override
  public void onApplicationEvent(final ContextRefreshedEvent event) {

    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.HOUR_OF_DAY, 5);
    cal.set(Calendar.MINUTE, 30);
           //I am passing same time in both calls but you can pass different dates 
    TimerClassExample.scheduleTaskOfDownload(cal.getTime(),TimeUnit.MILLISECONDS.convert(3, TimeUnit.HOURS));
        TimerClassExample.scheduleTaskOfDownload(cal.getTime(),TimeUnit.MILLISECONDS.convert(2, TimeUnit.HOURS)); 

   //also keeping interval as 2 and 3 hours respectively but you choose different interval like 24 hrs in that place
      }
    }