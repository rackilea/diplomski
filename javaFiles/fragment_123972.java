@Component
@EnableScheduling
public MySchdeduleClass {

      @Scheduled(fixedRate = 10 * 1000) //10 seconds
      public void taskThatRunsPeridically() {
          logger.info("Scheduled task method has been called ");
      }
}