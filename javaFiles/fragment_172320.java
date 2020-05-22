private final AtomicInteger count = new AtomicInteger(0);
// if you are using Java 8 I would prefer LongAddr
public T poll(){
   count.incrementAndGet();
   try {
        return super.poll()
   }finally{
      count.decrementAndGet();
   }
}