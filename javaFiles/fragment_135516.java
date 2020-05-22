import java.util.concurrent.CountDownLatch;
 ...

 // set the latch count to the nuber of callbacks to wait for
 CountDownLatch latch = new CountDownLatch(2);

 ServiceCallBackhandler callbackhandler =  new ServiceCallBackhandler() {
      public void handleResponse(Response response) {
           .... do real work ...
           latch.countDown();
      }
 };

 stub.startGetData("Foo",callbackhandler)
 stub.startGetData("bar",callbackhanlder)

 // wait for both callbacks to occur
 latch.await();