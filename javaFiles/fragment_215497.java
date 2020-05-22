public static synchronized void a(){
    System.out.println("Before sleep: A Method " +  Thread.currentThread().getName());
    try{
        Thread.sleep(100);
    } catch(InterruptedException e){
        Thread.currentThread().interrupt();
    }
    System.out.println("After sleep: A Method " +  Thread.currentThread().getName());
}