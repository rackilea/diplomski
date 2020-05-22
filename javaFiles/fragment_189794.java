public class StateMachineEx {

class A extends Thread {

    A() {
        setName("AThread");

    }
    @Override
    public void run(){
           Log.d ("XXX", "" + Thread.currentThread().getName()); // this gives A
    }
}

StateMachineEx(Context context) {
        new Handler(context.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                A mA = new A();               
                mA.start(); // start thread             
            }
        }, 0);
    }