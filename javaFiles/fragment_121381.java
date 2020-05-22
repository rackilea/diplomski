@RunWith(CamelSpringBootRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class SampleCamelApplicationTest {

    @Produce(uri = "activemq:queue:myIncomingQueue")
    protected ProducerTemplate template;

    @Test
    public void shouldProduceMessages() throws Exception {
        template.sendBody("test");
        Thread.sleep(20000); //wait for ActiveMQ redeliveries
    }

}