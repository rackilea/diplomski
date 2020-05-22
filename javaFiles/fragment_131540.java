public class MyCalculationclass {
     private final ExecutorService executorService = Executors.newCachedThreadPool();

     public String PerformCalculations (Object object){
       // perform calculation
       executorService.execute(() ->
           sendNotificationToUser(usernotificationToken, calculationValue));

       return "Success"

        }

     public void sendNotificationToUser(String usernotificationToken,String calculationValue ){

          // send user the notification
       }

}