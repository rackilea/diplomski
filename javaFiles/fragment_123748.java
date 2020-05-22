while(!(in.equals("quit"))){
  // System.out.println(q.isEmpty());
  synchronized(q){
    q.enqueue(in);
  }
  in = k.next();
  if(in.equals("quit"))
    System.exit(0);
}