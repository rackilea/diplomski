RequestHandlerAPI decoratedRequestHandler = 
     new RequestHandlerAPIDecorator(existingRequestHandler) {
         public void onRequestSent(Request request) {
             System.out.println("Request is sent.");
         }
     });