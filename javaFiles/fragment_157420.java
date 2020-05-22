public class SomethingElse extends Thread {

     private static Logger log = Logger.getLogger(SomethingElse.class);    

        public void run(){
            int ii=0;

            log = Logger.getLogger( "worker_2" + "." + SomethingElse.class.getName());
            log.info("--------------processing SomethingElse-----------------");

            try{
                while(ii<6){
                    log.info("This is something else! " + Thread.currentThread().getName() + " logger name: " + Thread.currentThread().getName() + "." + SomethingElse.class.getName());
                    log.info("SE ii="+ii);
                    ii++;
                    this.sleep(1000);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            this.interrupt();
        }    
}