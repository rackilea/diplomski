public class Worker extends Thread {

    public static Logger LOGGER = Logger.getLogger(Worker.class);   

    public void run(){
        int i=0;
        System.out.println("Lancement worker");

        LOGGER = Logger.getLogger( "worker_1" + "." + Worker.class.getName());
        LOGGER.info("--------------processing Worker-----------------");

        try{
            while(i<5){
                LOGGER.info("This is Worker! " + Thread.currentThread().getName() + " logger name: " + Thread.currentThread().getName() + "." + Worker.class.getName());
                LOGGER.info("W i="+i);
                i++;
                this.sleep(2000);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        this.interrupt();
    }
}