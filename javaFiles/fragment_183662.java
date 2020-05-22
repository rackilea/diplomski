public class Music implements Runnable{
    private Thread t;    //Make the thread object a class field

    //Just about everything is the same as it was before...

    public void stop(){
        play = false;
        try{
            t.join()
        }catch(InterruptedException e){
            //Don't do anything, it doesn't matter
        }
   }
}