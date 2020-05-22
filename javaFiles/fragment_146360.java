class Server{ 
    String msg;

    void sendMsg(String msg){
        this.msg = msg ;
    }
    public void proccess() throws InterruptedException{
        while(true){
            synchronized (Thread.currentThread()) { 
                Thread.currentThread().wait();          
            }
            System.out.println(Thread.currentThread().getName()+" : "+this.msg);
        }
    }
}