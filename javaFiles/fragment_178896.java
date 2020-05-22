class RunnableFoo extends Foo implements Runnable{

 public void run(){
     try{
         insertIntoDatabase(this);
     }catch(InterruptedException ex){
       ex.printStackTrace();
     }
 }
}