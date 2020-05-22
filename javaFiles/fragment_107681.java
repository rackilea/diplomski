public class Example{
  int counter = 0;

  synchronized void printCounter() throws Exception{
    notify();
    System.out.println(Thread.currentThread().getName() + "-->" + (counter++));
    wait();
  }

  public static void main(String[] args){
      Example example = new Example();
      Thread t1 = new MyThread(example);
      t1.setName("MyThread-1");
      Thread t2 = new MyThread(example);
      t2.setName("MyThread-2");
      t1.start();
      t2.start();
  }
}

class MyThread extends Thread{
    private Example obj = null;

    MyThread(Example obj){
        this.obj = obj;
    }

    public void run(){
        while(true){
            try{
                obj.printCounter();
                Thread.sleep(200);
            }catch(Exception ex){

            }
        }
    }
}