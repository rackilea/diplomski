private ThreadLocal<Object> responses;

public void onMessageReceived(Object response) {
   response.set(response);
} 

public Object sendMessage(byte[] data) {
   requestResponse(data);
   Object response = responses.get();
   responses.remove();
   return response;
}