public SwingWorker<Object,Void> returnSomeResult() {
    SwingWorker<Object,Void> w = new SwingWorker(){
        protected Void doInBackground(){
            Object o;
            //compute o in background thread
            return o;
        }
        protected void done(){
            Object o=get();
            //do something with o in the event thread
        }
    }
    w.execute();
    return w;//if you want to do something with it 
}