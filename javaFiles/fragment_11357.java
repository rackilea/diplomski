Deque q = new ConcurrentLinkedDeque<>();

//thread 1    
Object o = ...;
q.addFirst(o);

//thread 2
while(!q.isEmpty()){
    Object o = q.removeLast();
   //do something with o
}