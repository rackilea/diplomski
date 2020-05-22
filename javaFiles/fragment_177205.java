@Override
@Transactional
public void save() {
    String data = "Testing event data";
    MyBusinessEvent event = new MyBusinessEvent(data);
    applicationEventPublisher.publishEvent(event);
}