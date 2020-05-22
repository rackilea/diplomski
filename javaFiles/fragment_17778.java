class SaveOffsetsOnRebalance(consumer: Consumer[_, _] ) extends ConsumerRebalanceListener {

   def onPartitionsRevoked(partitions: Collection[TopicPartition]): Unit = {
       // save the offsets in an external store using some custom code not described
   partitions.toScala.forEach(
         saveOffsetInExternalStore(consumer.position(partition))
   )
   }

   def onPartitionsAssigned(partitions: Collection[TopicPartition]): Unit = {
       // read the offsets from an external store using some custom code not described here
       partitions.forEach(
          consumer.seek(partition, readOffsetFromExternalStore(partition)))
   }
 }