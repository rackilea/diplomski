public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

      public void onApplicationEvent(final ContextRefreshedEvent event) {
        ApplicationContext ctx = event.getApplicationContext();
        (new Thread() {
           public void run() {
             // do stuff
           }
         }).start();
      }

    }