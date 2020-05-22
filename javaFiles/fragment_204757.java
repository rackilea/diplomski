public void Reduce() {
     List<Thread> threadList = new ArrayList<>();
     for (int i = 1; i <= Chunks; i++) {
         Thread t  =new Thread(new RunThread(VecteurLines,i,this));
         threadList.add(t);
     }

     // start all worker threads
     for(int i=0; i<threadList.size(); i++){
         threadList.get(i).start();
         threadList.get(i).join();
     }
 }