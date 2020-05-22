public void fun(final char c, final int r){
    new Thread(new Runnable(){
        public void run(){
            try{ 
                while (!s.tryAcquire(r, 1, TimeUnit.MILLISECONDS)) {};
                System.out.println(c+"_"+r);
                s.release(r+1);
            } catch(Exception e){ e.printStackTrace(); }
        }
    }).start();
}