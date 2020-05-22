try(
    PipedOutputStream pos= new PipedOutputStream();
    PipedInputStream pis =new PipedInputStream(pos)
){ 
    AtomicBoolean isDone = new AtomicBoolean(false);
    NumGen ng = new NumGen(pos,isDone);
    RunningAvg ra = new RunningAvg(pis,isDone);

    ng.start();
    ra.start();

    try {
       ng.join(); // wait for ng and ra to complete
       ra.join(); //
    } catch(InterruptedException ie) {}
} catch (IOException e) {
    e.printStackTrace();
}