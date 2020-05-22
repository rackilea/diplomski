public class MyRunnableClass implements Runnable {

static int x = 25;
int y = 0;
private static final Object sharedLock = new Object();


@Override
public void run() {
    while(x>0){
        someMethod();
    }
}

public synchronized void someMethod(){
    synchronized (sharedLock){
        if(x > 0){
            x--;
            y++;
       }
    }
}