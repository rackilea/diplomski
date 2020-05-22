import java.util.concurrent.atomic.AtomicInteger;

class X {

    AtomicInteger a;
    AtomicInteger b;

    public void addA(){
        a.incrementAndGet();
    }

    public void addB(){ 
        b.incrementAndGet();
    }
}