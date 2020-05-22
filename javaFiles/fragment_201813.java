class MyServiceImplementaiton implements MyService {
    void myService() throws MyServiceException { // cannot change the throws clause here
        try {
            .... // Do something
        } catch(IOException e) {
            // re-wrap the received IOException as MyServiceException
            throw new MyServiceException(e); 
        }
    }
}