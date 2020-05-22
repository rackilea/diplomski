import javax.annotation.PostConstruct;
import org.apache.kafka.streams.KafkaStreams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PipelineRunner
{
    private final StreamsBuilder streamsBuilder;
    private final KafkaProperties kafkaProperties;
    private final SerdesExt serdesExt;


    @Autowired
    public PipelineRunner(StreamsBuilder streamsBuilder, KafkaProperties kafkaProperties, SerdesExt serdesExt)
    {
        this.streamsBuilder = streamsBuilder;
        this.kafkaProperties = kafkaProperties;
        this.serdesExt = serdesExt;
    }


    @PostConstruct
    public void run()
    {
        ReflectData.AllowNull.get().addStringable(Utf8.class);
        ReflectData.get().addStringable(Utf8.class);
        DataProcessor processor = new DataProcessor(streamsBuilder, kafkaProperties,
            serdesExt);
        start();
    }


    @Bean
    KafkaStreams kafkaStreams()
    {
        KafkaStreams kafkaStreams = new KafkaStreams(
            streamsBuilder.build(),
            kafkaProperties.getKafkaStreamsProperties(serdesExt));
        System.out.println("----Its is started----");
        kafkaStreams.start();
        return kafkaStreams;
    }
}