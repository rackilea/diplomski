@Component
public class QueueListener implements MessageListener {
   @Autowired
   private AuthService authService;

   @Autowired
   private SomeOtherService otherService;

   @Override
   public void onMessage(Message message) {
      JSONArray array = processInput();

      JSONArray obj = new JSONArray(jsonified);
      String identifier = obj.getJSONObject(0).getString("identifier");
      // extract the business logic to the service layer. Don't mix layer responsibilities
      otherService.doYourThing(obj, identifier);

      resolveMessage();
  }

  private JSONArray processInput(Message message) {
     String msg = new String(message.getBody());
     String output = msg.replaceAll("\\\\", "");
     String jsonified = output.substring(1, output.length()-1);


}