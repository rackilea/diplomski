public class ProduceAndConsume {
  private class Inner<IntermediateType> {
    private Producer<? extends IntermediateType> producer;
    private Consumer<IntermediateType> consumer;

    // Constructor omitted.

    private void doLater() {
      consumer.consume(producer.produce());
    }
  }

  private final Inner<?> inner;

  public <IntermediateType> ProduceAndConsume(Producer<? extends IntermediateType> producer, Consumer<IntermediateType> consumer) {
    this.inner = new Inner<>(producer, consumer);
  }

  private void doLater() { // Or just invoke inner.doLater() directly.
    inner.doLater();  
  }
}