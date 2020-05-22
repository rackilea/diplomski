public class Triage implements Observer,Runnable{
    Observable obsrvbl;
    private BlockingQueue<String> messages; 
    volatile static boolean interrupted=false;  
    Integer updated = 0;
    private static Random rand = new Random(47);

    Triage(Observable obsrvbl, BlockingQueue messages){
        this.obsrvbl=obsrvbl;
        this.messages = messages;
        obsrvbl.addObserver(this);
    }

    public void update(Observable o, Object arg){
        updated += ((Integer)arg);
        System.out.println("Updated: " + updated);
    }

    public void run(){
        String msg; 
        while(!interrupted){
            try{
                msg=messages.take();
                System.out.println("Run: " + msg);
            }catch(InterruptedException ie){}
        }
    }

    public static void main(String[] args){
        BlockingQueue<String> q1 = new LinkedBlockingQueue<String>();
        BlockingQueue<String> q2 = new LinkedBlockingQueue<String>();
        Producer p = new Producer(q1);
        new Thread(p).start();
        new Thread(new Triage(p,q2)).start();
        for(int i=0;i<20;i++){      
            int next = rand.nextInt(10)*500;
            System.out.println("Populating: " + next);
            q1.add((Integer.valueOf(next)).toString());
            q2.add((Integer.valueOf(next)).toString());         
        }
    }
}

class Producer extends Observable implements Runnable {
    volatile static boolean interrupted=false;
    private BlockingQueue<String> quotes;
    Producer(BlockingQueue quotes){
        this.quotes=quotes; 
    }
    public void run(){
        String msg;     
        while(!interrupted){    
            try{
                msg=quotes.take();
                if(msg!=null){
                    System.out.println("Notifying: " + msg);
                    setChanged();
                    notifyObservers(Integer.valueOf(msg));  
                }
            }catch(InterruptedException ie){}
        }
    }
}