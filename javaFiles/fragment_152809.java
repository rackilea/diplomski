@Before
public void setUp() throws Exception {
   // wait until the partitions are assigned
   for (MessageListenerContainer messageListenerContainer : 
        kafkaListenerEndpointRegistry.getListenerContainers()) {

       ContainerTestUtils.waitForAssignment(messageListenerContainer,
       embeddedKafka.getPartitionsPerTopic());
   }