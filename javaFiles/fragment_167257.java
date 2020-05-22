public class ThreadDemo extends Thread{

    @Override
    public void run(){
        while(true){
            // Your code here
            System.out.println(new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {              
            e.printStackTrace();
            }
        }
    }

    public static void main(String []args){
        ThreadDemo t = new ThreadDemo();
        t.start();
    }
}