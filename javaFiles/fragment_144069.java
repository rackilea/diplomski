//private updateNumber grab = new updateNumber();

    class threadOne extends Thread {
        private updateNumber grab = new updateNumber(); 
         public void run() {
            try{
             grab.increase(1); 
            }
            catch(Exception e){
             System.out.println("error in thread one");
            }
        }
    }