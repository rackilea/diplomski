public class SequenceNumberGenerator {  

    private static AtomicInteger counter = new AtomicInteger();  

    public static int nextVal() {  
        return counter.incrementAndGet();
    }    
}