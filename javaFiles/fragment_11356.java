ArrayList q = new ArrayList<>();

//thread 1    
Object o = ...;
synchronized(q) {
  q.add(o); //append
}

//thread 2
int i = 0;
synchronized(q) {
  int size = q.size();
  for(; i < size; i++){
    Object o = q.get(i);
    //do something with o
  }
  if(i >= size) {
    i = 0;
  }
}