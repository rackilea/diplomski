//lock is an instance of Object now, NOT a boolean variable
public void run(){ 
  synchronized(lock){
    lock.notifyAll();
    ...
    ...
    lock.wait();
  }
}