public class MyUntypedActor extends UntypedActor {
  public void onReceive(Object message) {
    if(message instanceOf String) {
       Object response = someFunction( (String) message);
       if(response instanceOf HTTPException) {
         Thread.sleep(1000);
         getSelf().tell(new RequestFailure((String) message, 1), getSender());
       } 
       else
         getSender().tell(response, getSelf())
    }
    else if(message instanceOf RequestFailure) {
      RequestFailure rf = (RequestFailure) message;
      if(rf.count <= 3) {
        Object response = someFunction(rf.request);
        if(response instanceOf HTTPException) {
          Thread.sleep(1000);
          getSelf().tell(new RequestFailure(rf.request, rf.count + 1), getSender();
        } 
        else
          getSender().tell(response, getSelf())
        }
      } 
      else
        //FIXME : question doesn't specify what to return 
        //        if max count reached   
    }
  }
}