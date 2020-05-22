@Primary
@Bean(name = "q1")
   public Queue queueAccountToNotification() {
      return new ActiveMQQueue(queueAccountToNotificationName);
}


public class JmsEventPublisher implements EventPublisher {

   final JmsTemplate jmsTemplate;
   @Qualifier("q1")
   final Destination destination;

     ..........

 }