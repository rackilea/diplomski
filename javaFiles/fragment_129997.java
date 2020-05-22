public class inner{
    public void changeOuter(){
        Thread myThread = new Thread(new Runnable(){
            public void run(){
                ft = "what?";
                System.out.println("run :" + ft);
            }
        });
        myThread.start();
        myThread.join(); // wait for the thread to finish before returning

    }
}