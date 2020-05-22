public class ThreadA extends Thread {

    private AtomicBoolean stop = new AtomicBoolean(false);

    public void run(){
        someClass.someMethod(stop);            
    }

    public void stopProcessing(){
        stop.set(true);
    }

}


public class SomeClass {

    public void someMethod(AtomicBoolean stop){
        while(!stop.get()){
           ...
        }
    }
}