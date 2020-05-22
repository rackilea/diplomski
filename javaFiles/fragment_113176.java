try{
  thread1.join();
  thread2.join();
}catch(InterruptedException e){
  e.printStackTrace();
}