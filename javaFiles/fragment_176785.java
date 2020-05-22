public class myRunnable implements Runnable, Serializable {

myTestClass mclass;

public myRunnable(){
    mclass = new myTestClass();
}


@Override
public void run(){

    try {
        System.out.println("Putting thread to sleep for 5 seconds");
        Thread.sleep(5000);
    }
    catch(Exception e){
        e.printStackTrace();
    }

    System.out.println("\nTesting MyRunnable on Thread: " + Thread.currentThread().getName());

}