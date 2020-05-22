ListWorker implements Runnable {

    private interface Command{
        void execute();
    }

private List<String> list;
private BlockingQueue<ListWorker.Command> work; // give it a Blocking Queue impl.
private volatile boolean bAddRandomElements;


public synchronized void deleteLastElement() {
     work.add( new Command(){
            @Override
            public void execute(){ /* delete Last Element of the list */ }
        } ); 
}

public synchronized void startAddingRandom() {
     work.add( new Command(){
            @Override
            public void execute(){ /* set switch bAddRandomElements */ }
        } ); 
}

public synchronized void stopAddingRandom() {
     work.add( new Command(){
            @Override
            public void execute(){ /* reset switch bAddRandomElements */ }
        } ); 
}

public synchronized void terminate() {
     work.add( new Command(){
            @Override
            public void execute(){ /* interrupt thread */ }
        } ); 
}


public ListWorker(List<String> list) {
   this.list = list;
}

public void run() {
    while(!Thread.interrupted()) {
       Command c = null;
       if( bAddRandomElements ){ 
           /* add random, assuming you add one random entry per iteration ... */
           c = work.poll( /*maybe specify timeout*/ ); // No command - just go on with it! We'll block in next iteration if bAddRandomElements is reset.
       }else{
           c = work.take(); // blocks until there is a command in queue.
       }

       if ( null != c ) c.execute();

    }
}