public void myMethod(String message, Long id) {
       if (message == null) {
          throw new IllegalArgumentException("myMethod's message can't be null");
          // The message doesn't log the argument because we know its value, it is null.
       }
       if (id == null) {
          throw new IllegalArgumentException("myMethod's id can't be null");
          // This case is separated from the previous one for two reasons :
          // 1. to output a precise message
          // 2. to document clearly in the code the requirements
       }
       if (message.length()<12) {
          throw new IllegalArgumentException("myMethod's message is too small, was '" + message + "'");
          // here, we need to output the message itself, 
          // because it is a useful debug information.
       }
     }