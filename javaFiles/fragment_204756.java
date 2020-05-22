private List<Thread> threadList = new ArrayList<>();

 public void Reduce() {
     threadList.clear();
     for (int i = 1; i <= Chunks; i++) {
         Thread t  =new Thread(new RunThread(VecteurLines,i,this));
         threadList.add(t);
     }

     // start all worker threads
     for(int i=0; i<threadList.size(); i++){
         threadList.get(i).start();
     }

     // wait until all worker threads is finished
     while (true) {
         int threadIsNotLive = 0;
         for (int i = 0; i < threadList.size(); i++) {
             Thread t = threadList.get(i);
             if (!t.isAlive() || t == null) {
                 ++threadIsNotLive;
             }
         }
         if(threadIsNotLive>0 && (threadList.size() == threadIsNotLive)){
             break;
             // all worker threads is finished
         }
         else {
             Thread.sleep(50);
             // wait until all worker threads is finished
         }
     }
 }