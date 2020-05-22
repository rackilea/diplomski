@Bean(name = "q1")
   public Queue queueAccountToNotification() {
      return new ActiveMQQueue(queueAccountToNotificationName);
}


@Bean(name = "q2")
   public Queue queueNotificationToAccount() {
      return new ActiveMQQueue(queueNotificationNameToAccount);
   }