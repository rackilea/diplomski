@Path("citas")
// ...
public class citaResource {

    @Inject
    com.softcase.citasmanager.websocket.SessionHandler handler;

    @GET
    // ...
    public Response cita() {
        // REST processing
        // ...

        // Websocket processing:
        // - Handler is always here for you
        // - Handler knows which websocket sessions to send the message to.
        //   The RestController is not aware of the recipients
        handler.sendMessage("Your Item was created");
    }

}