import kafka.server.KafkaConfig; 
import kafka.server.KafkaServerStartable;
import java.util.Properties;

public KafkaTest() {
    Properties properties = createProperties();
    KafkaConfig kafkaConfig = new KafkaConfig(properties);
    KafkaServerStartable kafka = new KafkaServerStartable(kafkaConfig);
    kafka.startup();
}