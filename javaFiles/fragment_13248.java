public class TheThreadClass extends Thread{
    private bool terminated;

    public void terminate(){
        this.terminate = true;
    }

    @Override
    public void run(){
        while(!terminated){
            // thread code here
        }
    }
}