static ReferenceQueue<MyObject> MY_QUEUE = new ReferenceQueue<MyObject>();
static class MyReference extends WeakReference<MyObject>{
  public final String name;
  public MyReference(MyObject o, ReferenceQueue<MyObject> q){
    super(o, q);
    name = o.toString();
  }
}

static{
  Thread t = new Thread(){
    public void run(){
      while(true){
        MyReference r = (MyReference)MY_QUEUE.remove();
        System.out.println(r.name+" eligible for collection");
      }
    }
  }
  t.setDaemon(true);
  t.start();
}

public MyObject(){
  //normal init...
  new MyReference(this, MY_QUEUE);
}