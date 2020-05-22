package ...

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/control")
public class KafkaProduceControlResource {

    @Inject
    KafkaController kafkaController;

    @POST
    @Path("/produce")
    public void produceMessage(String message) {
        kafkaController.produce(message);
    }
}