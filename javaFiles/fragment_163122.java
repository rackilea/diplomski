public static void main(String args[]) {
  Queue queue = ...;
  while(queue.waitForEvent()){
   queue.processNextEvent();
  }
}