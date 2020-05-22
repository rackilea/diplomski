Thread-1
 Load Class A
  synchronized(A.class){
    static: create new Thread (call it Thread-2)
    static: busy spin while (q.size() != amount); 

  }

Thread-2 (after first static)
  run(){
     A.q 
      Load Class A
      synchronized(A.class){ //block until Thread-1 releases the lock
           A.q.add(..);
      }
  }