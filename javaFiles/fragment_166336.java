public class Communicator {
  private static Communicator  mCommunicator = new Communicator();
  private PublishSubject<Void> mGrabEvent = new PublishSubjetct.create();
  private Communicator(){
  }
  public static getCommunicator(){
   return mCommunicator
  }
  public static emitEventItem(){
     // you can pass any object that you want to listen
     mGrabEvent.onNext(null);
  }
 public PublishSubject<Void> subscribeEvent(){
   return mGrabEvent;
 }
}