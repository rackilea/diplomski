public void whatever {
   try {
     methodThatMayThrowIOException();
     // do more stuff here that won't throw exceptions
     methodThatMayThrowCustomException();
   } catch(IOException io) {
     // do something with io exception here
   } catch(CustomException ce) {
     // do something with custom exception here
   }
}