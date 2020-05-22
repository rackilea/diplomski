@Component("findAndDisplayDataService")
   @Profile("quartz")
   public FindAndDisplayDataServiceQuartz implements FindAndDisplayDataService {
      public void formatHashrate(String hashrate){
        //do stuff based on quartz
      }
   }

   @Component("findAndDisplayDataService")
   @Profile("spring-scheduler")
   public FindAndDisplayDataServiceSpringScheduler implements FindAndDisplayDataService {
      public void formatHashrate(String hashrate){
        //do stuff based on Spring scheduler
      }
   }