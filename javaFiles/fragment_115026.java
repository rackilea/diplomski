final Iterator itr = ref.keySet().iterator();

new Thread("Iterator_1"){
    public  void run(){
        while(itr.hasNext()){
            System.out.println(Thread.currentThread()+"" + itr.next());
        }
    }
}.start();

new Thread("Iterator_2"){
    public  void run(){
        while(itr.hasNext()){
            System.out.println(Thread.currentThread()+"" + itr.next());
        }
    }
}.start();