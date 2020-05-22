public synchronized void leave(){
   this.size++;
   this.notify();
}

public synchronized void enter(){
   while(this.size==0){ 
       this.wait();
   }
   this.size--;
}