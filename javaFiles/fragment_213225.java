@Slf4j
@Component
@RequiredArgsConstructor
public class TopicListener {

  private final AvroKafkaMessageConverter messageConverter;

  @KafkaListener(topics = {"test-request"})
  public void listenForMessage(ConsumerRecord<?, ?> consumerRecord) {
    log.info("listenForMessage. got a message: {}", consumerRecord);
    Request request = messageConverter.convertFromInternal(
        consumerRecord, Request.class, MimeType.valueOf("application/vnd.*+avr"));
    log.info("request message: {}", request.getMessage());
  }
}