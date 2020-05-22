MyThreadTry() {
     int times = 100000; 
     for(int i = 0; i <= times; i++ ){
         this.minPrime = i;
         System.out.println(this.minPrime);
         MyThreadMainGui myg = new MyThreadMainGui(null, threadSuspended);
         myg.updateProgress((int)this.minPrime);
     }
 }