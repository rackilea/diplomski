public static <T extends Exception> void checkForException(String message, 
        Class<T> exceptionType, ExpectedExceptionBlock<T> block) {
    try {
       block.exceptionThrowingCode();
   } catch (Exception ex) {
       if ( exceptionType.isInstance(ex) ) {
           return;
       } else {
          throw ex;  //optional?
       }
   }
   fail(message);
}

//...
checkForException("Expected an NPE", NullPointerException.class, //...