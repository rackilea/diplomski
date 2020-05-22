@Singleton
public class EmailSender {
     Queue<Email> queue;

     @Schedule(second = "*/5", minute = "*", hour = "*")
     public void sendEmail(String msg){
          if (!queue.isEmpty()) {
               //get queue element and send email
          }
     }
}