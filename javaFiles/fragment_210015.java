@Component
public class Consumer {

   @Autowired ConnectionFactory cf;

     public void request(Queue queue) {
        // use the connection factory here
     }
}