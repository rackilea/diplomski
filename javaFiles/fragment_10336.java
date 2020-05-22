class Main {
    private final Runway[] runways = { new Runway(), new Runway() };

    void main(){
        Thread maintainer = new Thread(){
            public void run(){
               try{
                     Thread.sleep(500);
                     for(Runway runway : runways){
                           runway.ready = true;
                           runway.notifyAll();
                     }
               }catch(InterruptedException e){}
        };
        maintainer.start();
        for(int i=0; i<5; i++){
             System.out.println("Plane #" + i + " attempting to land.");
             Runway runway = runways.get(i%runways.length);
             runway.land(new Plane(i));
        }
    }
}    


class Runway {
    boolean ready; //getter/setter omitted..

    public synchronized land(Plane plane){
       //You always have to wait like this, never `if (something) wait();`  
       while(!ready){
             wait();
       }
       //We have the lock and runway is ready
       System.out.println(plane + " landed.");
       ready = false; //runway is littered?
    }
}