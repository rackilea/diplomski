class ThreadExample implements Runnable
{
    public static void main(String[] args) {
        Thread t = new Thread(new ThreadExample());
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