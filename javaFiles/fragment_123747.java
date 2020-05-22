synchronized(q){
  while(!(in.equals("quit"))){
    // System.out.println(q.isEmpty());
    q.enqueue(in);
    in = k.next();
    if(in.equals("quit"))
      System.exit(0);
  }
}