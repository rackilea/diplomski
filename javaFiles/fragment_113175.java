public staic void main(String args[]){
  Thread thread1 = new Thread(){
    public void run(){
      for(int i = 0; i < 100; i++){
       System.out.println(i);
      }
    }
  }
  Thread thread2 = new Thread(){
     public void run(){
      for(int i = 0; i < 100; i++){
        System.out.println(i);
      }
    }
  }
  thread1.start();
  thread2.start();
}