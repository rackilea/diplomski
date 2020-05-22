public class Number1{    
    public static void main(String[] args){

        try{
        Thread a = new Thread(new thread1("A"));
        Thread b = new Thread(new thread1("B"));
        Thread c = new Thread(new thread1("C"));
        a.start();
        b.start();
        c.start();
        a.join(1000);
        b.join(1000);
        c.join(1000);
        }
        catch(InterruptedException e) {
                System.out.println("Error");
            }


    }
}

class thread1 implements Runnable{

    String character;


    public thread1(String a){
        this.character = a;
    }

    public void run(){
            for(int i = 1;i<21;i++)
             {           
               Thread.sleep(1000);// This will make the current thread sleep for 1 second  
           System.out.println("No."+i+" Thread: "+character);
            }
    }
}