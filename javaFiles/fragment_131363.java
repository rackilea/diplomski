/** A generic processor that should be able to work with any type of consumer or producer */
public class GenericProcessor<T> implements IProcessor<T> {

    IProducer<? extends T> producer;
    IConsumer<? super T> consumer;

    public GenericProcessor(IProducer<? extends T> p, IConsumer<? super T> c) {
        this.producer = p;
        this.consumer = c;
    }

    @Override
    public void process() {
        T item = null;
        // As long the producer produces items, keep processing them
        while ((item = producer.produce()) != null) {
            this.process(item);
        }
    }

    @Override
    public void process(T item) {
        consumer.consume(item);
    }
}