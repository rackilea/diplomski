public class EventLogDecoder implements Decoder<EventLog> {

 public EventLogDecoder(VerifiableProperties verifiableProperties) {
 }

 @Override
 public EventLog fromBytes(byte[] bytes) {
   ObjectMapper objectMapper = new ObjectMapper();
   try {
     return objectMapper.readValue(bytes, EventLog.class);
   } catch (IOException e) {
     //do something
   }
   return null;
 }
}