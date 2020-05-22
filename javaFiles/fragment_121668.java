package ...

import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.reactivestreams.Publisher;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.smallrye.reactive.messaging.kafka.KafkaMessage;

@ApplicationScoped
public class KafkaController {

    private FlowableEmitter<KafkaMessage<String, String>> emitter;

    private Flowable<KafkaMessage<String, String>> outgoingStream;

    @PostConstruct
    void init() {
        outgoingStream = Flowable.create(emitter -> this.emitter = emitter, BackpressureStrategy.BUFFER);
    }

    public void produce(String message) {
        emitter.onNext(KafkaMessage.of(UUID.randomUUID().toString(), message));
    }

    @PreDestroy
    void dispose() {
        emitter.onComplete();
    }

    @Outgoing("internal")
    Publisher<KafkaMessage<String, String>> produceKafkaMessage() {
        return outgoingStream;
    }

    @Incoming("internal")
    @Outgoing("kafka-test")
    KafkaMessage<String, String> transform(Message<KafkaMessage<String, String>> arg) {
        return arg.getPayload();
    }
}