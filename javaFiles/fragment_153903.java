Queue<T> q = new LinkedBlockingQueue<>();
...
while(true){
    T t = q.take();
    //t will never be null, do something with it here.
}