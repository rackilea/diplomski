public class JmsEventPublisher implements EventPublisher {

  final JmsTemplate jmsTemplate;
  final Destination q1; // q1 or q2
  .....
}