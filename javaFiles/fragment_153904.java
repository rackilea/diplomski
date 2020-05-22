Queue<T> q = new LinkedList<>();
...
while(true){
    T t;
    while((t = q.poll()) == null); //busy polling!
    //t will never be null, do something with it here
}