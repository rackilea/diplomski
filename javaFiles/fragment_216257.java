public void print(){
    synchronized(B.class) {
         int i;
         for (i=0;i<1000;i++) {
             System.out.println(Thread.currentThread().getName() );
         }
    }
}