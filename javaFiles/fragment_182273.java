public class ClientWrapper extends ApacheHttpClient {
   private ApacheHttpClient delegate;

   public ClientWrapper(ApacheHttpClient client) {
      this.client = client;
   }

   @Override
   public Response execute(Request request, Request.Options options) throws IOException {
      /* execute the request on the delegate */
      Response response = this.client.execute(request, options);

      /* check the response code and change */
      if (response.status() == 400) {
         response = Response.builder(response).status(200).build();
      }
      return response;
   }
}