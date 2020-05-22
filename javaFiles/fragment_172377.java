class Worker extends SwingWorker<Void, Void> {

    @Override
    protected Void doInBackground() throws Exception {

    mapp();    
    while(!isCancelled()){
        Thread.sleep(60);
    }
     System.out.println("SwingWorker - isCancelled");    
        return null;       
}