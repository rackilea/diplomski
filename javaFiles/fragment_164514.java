//this why not working???
for(Thread t : myThread){
    if(t.getName().equalsIgnoreCase("EZ")){
        t= Thread.currentThread();
        t.interrupt();
        myThread.remove(t);
    }
}