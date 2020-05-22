/* import statements */
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.common.TopicPartition;
import java.util.Map;
import java.util.Properties;
import kafka.admin.AdminClient;
import scala.collection.JavaConverters;

/* code snippet */
Properties props = new Properties();
props.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

AdminClient adminClient = AdminClient.create(props);
scala.collection.immutable.Map<TopicPartition, Object> offsets =
adminClient.listGroupOffsets("foo");    
Map<TopicPartition, Object> javaOffsets =
JavaConverters.mapAsJavaMapConverter(offsets).asJava();

Object key = javaOffsets.get(new TopicPartition("my-topic", 0));
System.out.println(Long.parseLong(key.toString()));