public class LineProcessor extends UntypedActor{

  @Override
  public void onReceive(Object msg) throws Exception {
    if (msg instanceof ProcessLine){
      ProcessLine pl = (ProcessLine)msg;

      //Do whatever line processing...

      getSender().tell(Messages.LINE_PROCESSED, getSelf());
    }
  }

}