public class FilesProcessor extends UntypedActor{
  private List<String> files;
  private int awaitingCount;
  private ActorRef router;

  @Override
  public void onReceive(Object msg) throws Exception {
    if (msg instanceof ProcessFiles){      
      ProcessFiles pf = (ProcessFiles)msg;
      router = ... //lookup router;
      files = pf.fileNames;
      processNextFile();
    }
    else if (msg instanceof LineProcessed){
      awaitingCount--;
      if (awaitingCount <= 0){
        processNextFile();
      }
    }

  }

  private void processNextFile(){
    if (files.isEmpty()) getContext().stop(getSelf());
    else{            
      String file = files.remove(0);
      BufferedReader in = openFile(file);
      String input = null;
      awaitingCount = 0;

      try{
        while((input = in.readLine()) != null){
          router.tell(new Messages.ProcessLine(input), getSelf());
          awaitingCount++;
        }        
      }
      catch(IOException e){
        e.printStackTrace();
        getContext().stop(getSelf());
      }

    }
  }

  private BufferedReader openFile(String name){
    //do whetever to load file 
    ...
  }

}