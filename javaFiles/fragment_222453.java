class ThreadExample implements Runnable
{
    public void main(){
        Thread t= new Thread(this);
        t.start();
    }

    public void run(){
        int i;

        try{
            Thread.sleep(1000); 
            for(i=0;i<=5;i++){
                System.out.println(i);
            }
        }
        catch(InterruptedException e){
        }
    }
}