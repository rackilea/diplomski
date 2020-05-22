public class MyKafkaListener {

    private final MyService myService;

    public MyKafkaListener(MyService myService) {
        this.myService = myService;
    }


    @KafkaListener
    public void receiveMessage(String message) {
            this.myService.handleMessage(message);
    }

}

...

@Bean
public MyKafkaListener myKafkaListener() {
   return new MyKafkaListener(myServiceImpl());
}