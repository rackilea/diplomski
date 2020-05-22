import org.apache.kafka.clients.consumer.{KafkaConsumer, OffsetAndMetadata}
import org.apache.kafka.common.TopicPartition

import collection.mutable.Map
import collection.JavaConverters._

//initialise your consumer the way you want
val consumer = createKafkaConsumer(config, subscriptions)

//you could accept a scala.collection.mutable.Map here
def commitSync(offsets: Map[TopicPartition, OffsetAndMetadata]) = {
    //and then convert it to a java.util.Map
    consumer.commitSync(offsets.asJava)
}