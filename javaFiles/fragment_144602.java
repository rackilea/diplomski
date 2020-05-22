public boolean offer(E e) {
       if(doNow)
         return linkedBlockingDequeInstance.offerFirst(e);
      else 
         return linkedBlockingDequeInstance.offerLast(e);
   }