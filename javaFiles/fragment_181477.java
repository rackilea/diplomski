public class TestThread
{
    public static void main(String[] args){
        Thread r=Thread.currentThread();
        r.setPriority(Thread.MAX_PRIORITY);
        NewThread hi=new NewThread(Thread.MAX_PRIORITY);
        NewThread lo=new NewThread(Thread.MIN_PRIORITY);
        hi.start();
        lo.start();
        try{
            r.sleep(5000);
        }catch(InterruptedException e){
            System.out.println("caught");
        }
        hi.interrupt();
        lo.interrupt();

        System.out.println("hi="+hi.clicker);
        System.out.println("lo="+lo.clicker);
    }
}
class NewThread extends Thread{
    long clicker=0;

    NewThread(int p){
        setPriority(p);
    }
    public void run(){
        while(true){
            clicker++;
        }
    }
}