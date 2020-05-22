public class MyListener implements BatchAcknowledgingMessageListener<String, String> {

    private final MyService service;

    public MyListener(MyService service) {
        this.service = service;
    }

    @Override
    public void onMessage(List<ConsumerRecord<String, String>> data, Acknowledgment acknowledgment) {
        data.forEach(dat -> this.service.call(dat.value()));
        acknowledgment.acknowledge();
    }

    public interface MyService {

        void call(String toCall);

    }

}