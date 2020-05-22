public class MedicalDeviceWorkManager {

   private ConcurrentHashMap<String, DelegatedWorker > devices = new ConcurrentHashMap<...>();

   private final ExecutorService worker = Executors.newFixedThreadPool(10);

   public void registerDevice(String device, Runnable singleUnitOfWork){
         devices.put(device,new DelegatedWorker (singleUnitOfWork));
   } 

   public void startDevice(String device){
        devices.get(device).startDevice();
   }    
   public void stopDevice(String device){
        devices.remove(device).stopDevice();
   }    
   public void pauseDevice(String device){
        devices.get(device).pauseDevice();
   }    
   private class DelegatedWorker { 
      private final Runnable r;
      private volatile Future<?> running;
      DelegatedWorker (Runnable r) {this.r =r ;}

       public void startDevice(){
            if(running != null){
               running = worker.submit(new Callable<Object>(){

                public Object call(){
                     if(Thread.interrupted())return null;
                        r.run();
                     if(Thread.interrupted())return null;

                     return worker.submit(this);
                   }
              });
             }           
       }    
       public void stopDevice(){
            pauseDevice();
       }    
       public void pauseDevice(){
          if(running!=null){ 
              running.cancel(true);
              running = null;
           }
       }    
     }
   }