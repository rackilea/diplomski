class threadOne extends Thread {
    private updateNumber grab;
     public void run() {
        try{
         grab.increase(1); // null pointer reference...<<<<<<<
        }
        catch(Exception e){
         System.out.println("error in thread one");
        }
    }
}