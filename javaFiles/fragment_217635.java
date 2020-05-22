public abstract class RequestHandlerAPIDecorator implements RequestHandlerAPI {

     protected final RequestHandlerAPI delegate;

     public RequestHandlerAPIDecorator(RequestHandlerAPI delegate) {
         this.delegate = Objects.requireNonNull(delegate, "delegate must not be null.");
     }

     public void onRequestProcessing(Request request) {
         delegate.onRequestProcessing(request);
     }

     // Etc. You IDE will happily generate delegate methods for you.
 }