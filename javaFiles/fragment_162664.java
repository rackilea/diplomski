@Component
public class RabbitMQConsumer 
{
    @RabbitListener(queues = "${queueName}")
    public void recievedMessage(Employee employee) {
        System.out.println("Recieved Message From Queue " + employee);
    }

    @RabbitListener(queues = "${queueName}")
    public void recievedMessage1(String string) {
        System.out.println("Recieved Message From Queue " + string);
    }

}