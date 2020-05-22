public void run(){
  while (true) {
    synchronized(q){
      while(!q.isEmpty()){
        String out = q.dequeue();
        System.out.println(out);
      }
    }
  }
}